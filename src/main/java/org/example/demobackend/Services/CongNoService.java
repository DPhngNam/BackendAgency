package org.example.demobackend.Services;

import org.example.demobackend.Models.baocaocongno;
import org.example.demobackend.Models.baocaocongnoID;
import org.example.demobackend.Models.daily;
import org.example.demobackend.Repository.CongNoRepository;
import org.example.demobackend.Repository.DaiLyRepository;
import org.example.demobackend.Repository.PhieuXuatHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class CongNoService {
    private static CongNoRepository congNoRepository;
    private static DaiLyRepository dailyRepository;
    private final PhieuXuatHangRepository phieuXuatHangRepository;

    @Autowired
    public CongNoService(CongNoRepository congNoRepository,
                         DaiLyRepository dailyRepository, PhieuXuatHangRepository phieuXuatHangRepository) {
        this.congNoRepository = congNoRepository;
        this.dailyRepository = dailyRepository;
        this.phieuXuatHangRepository = phieuXuatHangRepository;
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

        congNoRepository.saveAll(bccnList);
    }

    public List<baocaocongno> getCongNo(int thang, int nam) {
        List<baocaocongno> bccnList = new ArrayList<>();
        List<daily> dailyList = dailyRepository.getAllDaiLy();
        for (daily daily : dailyList) {
            baocaocongno bccn = congNoRepository.getCongNoByDaiLy(thang, nam, daily.getMadaily());
            if (bccn == null) {
                bccn = new baocaocongno(
                        new baocaocongnoID(thang, nam, daily),
                        0,
                        0,
                        0);
            }
            else{
                updateNoDau(bccn);
                updateNoCuoi(bccn);
            }
            bccnList.add(bccn);
        }
        return bccnList;
    }

    public void updateNoDau (baocaocongno bccn) {

        Integer noDau = congNoRepository.getCongNoByDaiLy(bccn.getBaocaocongnoID().getThang() - 1, bccn.getBaocaocongnoID().getNam(), bccn.getBaocaocongnoID().getMadaily().getMadaily()).getNoCuoi();
        if (noDau == 0) {
            noDau = 0;
        }
        bccn.setNoDau(noDau);
    }

    public void updatePhatSinh (baocaocongno bccn) {

    }

    public void updateNoCuoi (baocaocongno bccn) {
        daily daily = dailyRepository.getDaiLyById(bccn.getBaocaocongnoID().getMadaily().getMadaily());
        bccn.setNoCuoi(daily.getTienno());
    }

    public void createCongNo(baocaocongno bccn) {
        congNoRepository.save(bccn);
    }
}
