package com.example.asm_ps09981_qlsv.model;


import java.io.Serializable;
import java.util.Date;

public class SinhVien implements Serializable {
    private int maSv;
    private String tenSv;
    private Date ngaySinh;
    private String hinh;
    private String maLopHoc;

    public SinhVien(String ten, Date parse, String hinh) {
    }

    public SinhVien(int maSv, String tenSv, Date ngaySinh, String hinh, String maLopHoc) {
        this.maSv = maSv;
        this.tenSv = tenSv;
        this.ngaySinh = ngaySinh;
        this.hinh = hinh;
        this.maLopHoc = maLopHoc;
    }

    public SinhVien(String tenSv, Date ngaySinh, String hinh, String maLopHoc) {
        this.tenSv = tenSv;
        this.ngaySinh = ngaySinh;
        this.hinh = hinh;
        this.maLopHoc = maLopHoc;
    }

    public int getMaSv() {
        return maSv;
    }

    public void setMaSv(int maSv) {
        this.maSv = maSv;
    }

    public String getTenSv() {
        return tenSv;
    }

    public void setTenSv(String tenSv) {
        this.tenSv = tenSv;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getHinh() {
        return hinh;
    }

    public void setHinh(String hinh) {
        this.hinh = hinh;
    }

    public String getMaLopHoc() {
        return maLopHoc;
    }

    public void setMaLopHoc(String maLopHoc) {
        this.maLopHoc = maLopHoc;
    }
}


