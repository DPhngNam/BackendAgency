package org.example.demobackend.Services;

import org.example.demobackend.Models.mathang;
import org.example.demobackend.Models.thamso;
import org.example.demobackend.Repository.MatHangRepository;
import org.example.demobackend.Repository.ThamSoRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThamSoService {
    private final ThamSoRepository thamSoRepository;
    private MatHangRepository matHangRepository;
    @Autowired
    public ThamSoService(ThamSoRepository thamSoRepository, MatHangRepository matHangRepository) {
        this.thamSoRepository = thamSoRepository;
        this.matHangRepository = matHangRepository;
    }

    public boolean addThamSo(thamso thamso) {
        try {
            thamso existingThamSo = thamSoRepository.getThamSoByTen(thamso.getTenThamSo());
            if (existingThamSo != null) {
                return false;
            }
            thamSoRepository.save(thamso);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public int getThamSo(String tenThamSo) {
        thamso thamso = thamSoRepository.getThamSoByTen(tenThamSo);
        if (thamso == null) {
            return -1;
        }
        return thamso.getGiatri();
    }

    public Iterable<thamso> getAllThamSo() {
        return thamSoRepository.findAll();
    }

    public boolean updateThamSo(@NotNull thamso thamso) {
        thamso existingThamSo = thamSoRepository.getThamSoByTen(thamso.getTenThamSo());
        if (existingThamSo != null) {
            if(thamso.getTenThamSo().equals("Số đại lý tối đa trong một quận")){
                if(thamso.getGiatri() < existingThamSo.getGiatri()){
                    return false;
                }
            } else if (thamso.getTenThamSo().equals("Tỷ lệ đơn giá xuất")) {
                if(thamso.getGiatri() > existingThamSo.getGiatri()){
                    return false;
                }
                List<mathang> mathangs = matHangRepository.getAllMatHang();
                for (mathang mathang : mathangs) {
                    mathang.setDongiaxuat(mathang.getDongianhap() * thamso.getGiatri() / 100);

                }
                matHangRepository.saveAll(mathangs);
            }
            thamSoRepository.save(thamso);
            return true;
        }
        return false;
    }
}
