package org.example.demobackend.Services;

import org.example.demobackend.Models.thamso;
import org.example.demobackend.Repository.ThamSoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ThamSoService {
    private final ThamSoRepository thamSoRepository;
    @Autowired
    public ThamSoService(ThamSoRepository thamSoRepository) {
        this.thamSoRepository = thamSoRepository;
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

    public boolean updateThamSo(thamso thamso) {
        thamso existingThamSo = thamSoRepository.getThamSoByTen(thamso.getTenThamSo());
        if (existingThamSo != null) {
            if(thamso.getTenThamSo().equals("Số đại lý tối đa trong một quận")){
                if(thamso.getGiatri() < existingThamSo.getGiatri()){
                    return false;
                }
            }
            thamSoRepository.save(thamso);
            return true;
        }
        return false;
    }
}
