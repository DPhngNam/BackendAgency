package com.example.demo.Models.BaoCaoCongNo;

import com.example.demo.Models.baocaocongno;

public interface BCCNBuilder {
    BCCNBuilder setMaBaoCaoCongNo(String maBaoCaoCongNo);
    BCCNBuilder setThang(String thang);
    BCCNBuilder setNam(String nam);
    BCCNBuilder setMaDaiLy(String maDaiLy);
    BCCNBuilder setNoDau(String noDau);
    BCCNBuilder setNoCuoi(String noCuoi);
    BCCNBuilder setPhatSinh(String phatSinh);
    baocaocongno build();
}
