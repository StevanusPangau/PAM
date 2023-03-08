package com.example.pam_672020273;

public class Tabung {
    private int jari;
    private int tinggi;

    public Tabung(int jari, int tinggi) {
        this.jari = jari;
        this.tinggi = tinggi;
    }

    public int getJari() {
        return jari;
    }

    public void setJari(int jari) {
        this.jari = jari;
    }

    public int getTinggi() {
        return tinggi;
    }

    public void setTinggi(int tinggi) {
        this.tinggi = tinggi;
    }
    public double getLuasAlas(){
        return Math.PI * this.jari * this.jari;
    }
    public double getVolume() {
        return this.getLuasAlas() * this.tinggi;
    }
}
