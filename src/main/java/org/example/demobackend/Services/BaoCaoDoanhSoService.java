package org.example.demobackend.Services;

import org.example.demobackend.Models.baocaodoanhso;
import org.example.demobackend.Models.ctbcds;
import org.example.demobackend.Repository.BaoCaoDoanhSoRepository;
import org.example.demobackend.Repository.PhieuXuatHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BaoCaoDoanhSoService {
    private static BaoCaoDoanhSoRepository baoCaoDoanhSoRepository;
    private static PhieuXuatHangRepository phieuXuatHangRepository;

    @Autowired
    public BaoCaoDoanhSoService(BaoCaoDoanhSoRepository baoCaoDoanhSoRepository, PhieuXuatHangRepository phieuXuatHangRepository) {
        this.baoCaoDoanhSoRepository = baoCaoDoanhSoRepository;
        this.phieuXuatHangRepository = phieuXuatHangRepository;
    }

    public static baocaodoanhso getBaoCaoDoanhSoByMaBaoCaoDS(int mabaocaods) {
        return baoCaoDoanhSoRepository.getBaoCaoDoanhSoByMaBaoCaoDS(mabaocaods);
    }

    public static List<baocaodoanhso> getBaoCaoDoanhSoByThang(int thang) {
        return baoCaoDoanhSoRepository.getBaoCaoDoanhSoByThang(thang);
    }

    public static List<baocaodoanhso> getBaoCaoDoanhSoByNam(int nam) {
        return baoCaoDoanhSoRepository.getBaoCaoDoanhSoByNam(nam);
    }

    public static List<baocaodoanhso> getBaoCaoDoanhSoByThangAndNam(int thang, int nam) {
        return baoCaoDoanhSoRepository.getBaoCaoDoanhSoByThangAndNam(thang, nam);
    }

    public static int getThangByMaBaoCaoDS(int mabaocaods) {
        return baoCaoDoanhSoRepository.getThangByMaBaoCaoDS(mabaocaods);
    }

    public static int getNamByMaBaoCaoDS(int mabaocaods) {
        return baoCaoDoanhSoRepository.getNamByMaBaoCaoDS(mabaocaods);
    }

    public static Map<String, Integer> getThangAndNamByMaBaoCaoDS(int mabaocaods) {
        return baoCaoDoanhSoRepository.getThangAndNamByMaBaoCaoDS(mabaocaods);
    }

    public static List<Integer> getMaBaoCaoDSByThangAndNam(int thang, int nam) {
        return baoCaoDoanhSoRepository.getMaBaoCaoDSByThangAndNam(thang, nam);
    }

    public static List<baocaodoanhso> getAllBaoCaoDoanhSo() {
        return (List<baocaodoanhso>) baoCaoDoanhSoRepository.findAll();
    }

    public static int createBaoCaoDoanhSo(baocaodoanhso newBaoCaoDoanhSo) {
        try{
            baocaodoanhso savedBaoCaoDoanhSo = baoCaoDoanhSoRepository.save(newBaoCaoDoanhSo);
            return savedBaoCaoDoanhSo.getMabaocaods();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}

    /*
        public List<ctbcds>  (thang, nam)

            Repo baocaodoanhso save (new bcds) what is this?


            
            1 ct : tong tien tri gia cua Dai ly A theo thang nam  => sum1

            int sum += tatca tri gia phieu xuat cua tat ca dai ly trong cung thang - nam
            for(ct : ct){
                ctbcds.settyle = sum1/ sum
            }

            m giải thích lại luôn đi, là làm được tới cái bước chỉnh pxh với tạo bcds lấy mã ròi á


            thang, nam
            daily A co n pxh => m tong tri gia
                B
                C
                D
            là tổng trị giá là tổng tiền của n cái phiếu xuất hàng của daily A trong tháng đó năm đó
            ye hiểu

            thang, nam
            mA + mB +... = sumTong

            ctbaocaodanhso
            daily , sophieuxuat, tong tri gia m, ty le = m/sum
            => List

            daily nạp từ đâu vào z
            là nạp vào đại lý, đếm số phiếu xuất của đại lý đó trong tháng đó năm đó
            tính 2 cái tổng, 1 cái là tổng trị giá của đại lý đó trong tháng đó năm đó, 1 cái là tổng tr giá của tổng các đại lý
            ròi chia ra tỷ lệ
            z hả
            đếm spx là getSoPhieuXuatByMaDailyAndThangAndNam
            nạp cái mã đại lý giống bên postman khi nãy
            getTongTienPhieuXuatByMaDailyAndThangAndNam là tổng 1
            getTongTienPhieuXuatByThangAndNam là tổng 2
            ròi chia tỷ lệ
            nguyên cái mớ này tính toán trong cái ctbcds hả ngay cái chỗ create
            oke để t mò trước ròi t push lên, mai sai thì sửa




     */
