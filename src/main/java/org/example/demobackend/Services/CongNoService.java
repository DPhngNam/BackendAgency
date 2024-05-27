package org.example.demobackend.Services;

import org.example.demobackend.Models.baocaocongno;
import org.example.demobackend.Models.baocaocongnoID;
import org.example.demobackend.Models.daily;
import org.example.demobackend.Repository.CongNoRepository;
import org.example.demobackend.Repository.DaiLyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class CongNoService {
    private static CongNoRepository congNoRepository;
    private static DaiLyRepository dailyRepository;

    @Autowired
    public CongNoService(CongNoRepository congNoRepository,
                         DaiLyRepository dailyRepository) {
        this.congNoRepository = congNoRepository;
        this.dailyRepository = dailyRepository;
    }
    @Scheduled(cron = "0 0 0 1 * ?")
    public void autoCreateBaoCaoCongNo() {
        List<daily> dailyList = dailyRepository.getAllDaiLy();
        int currentMonth = LocalDate.now().getMonthValue();
        int currentYear = LocalDate.now().getYear();
        List<baocaocongno> bccnList = new ArrayList<>();
        for (daily daily : dailyList) {
            baocaocongno bccn = new baocaocongno(
                    new baocaocongnoID(currentMonth, currentYear, daily),
                    0,
                    0,
                    0);

            bccnList.add(bccn);
        }
        updateNoDau(bccnList);
        congNoRepository.saveAll(bccnList);
    }

    public List<baocaocongno> getCongNo(int thang, int nam) {
        List<baocaocongno> bccnList= congNoRepository.getCongNo(thang, nam);
        if (bccnList.isEmpty()){
            return null;
        }
        updateNoDau(bccnList);
        updateNoCuoi(bccnList);
        return bccnList;
    }

    public void updateNoDau (List<baocaocongno> bccnList) {
        for (baocaocongno bccn : bccnList) {
            baocaocongno temp = congNoRepository.getCongNoByDaiLy(bccn.getBaocaocongnoID().getThang()-1,
                    bccn.getBaocaocongnoID().getNam(),
                    bccn.getBaocaocongnoID().getMadaily().getMadaily());
            if (temp != null){
                bccn.setNoDau(temp.getNoCuoi());
            }else{
                bccn.setNoDau(0);
            }
            congNoRepository.save(bccn);
        }
    }

    public void updateNoCuoi (List<baocaocongno> bccnList) {
        for (baocaocongno bccn : bccnList) {
            daily daily = dailyRepository.getDaiLyById(bccn.getBaocaocongnoID().getMadaily().getMadaily());
            bccn.setNoCuoi(daily.getTienno() + bccn.getPhatSinh());
            congNoRepository.save(bccn);
        }
    }

    public void createCongNo(baocaocongno bccn) {
        congNoRepository.save(bccn);
    }
}
