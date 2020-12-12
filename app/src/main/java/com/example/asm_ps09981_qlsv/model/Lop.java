package com.example.asm_ps09981_qlsv.model;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Lop implements Serializable {
    private String malop, tenlop;

    public Lop() {
    }

    public Lop(String malop, String tenlop) {
        this.malop = malop;
        this.tenlop = tenlop;
    }

    public String getMalop() {
        return malop;
    }

    public void setMalop(String malop) {
        this.malop = malop;
    }

    public String getTenlop() {
        return tenlop;
    }

    public void setTenlop(String tenlop) {
        this.tenlop = tenlop;
    }


    @NonNull
    @Override
    public String toString(){
        return malop+" - "+tenlop;
    }

}
