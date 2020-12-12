package com.example.asm_ps09981_qlsv.model;

public class Student {

    String maSV, maLop,tenSV;

    public Student() { }

    public Student(String maSV, String maLop, String tenSV) {
        this.maSV = maSV;
        this.maLop = maLop;
        this.tenSV = tenSV;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getMaLop() {
        return maLop;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }

    public String getTenSV() {
        return tenSV;
    }

    public void setTenSV(String tenSV) {
        this.tenSV = tenSV;
    }


}
