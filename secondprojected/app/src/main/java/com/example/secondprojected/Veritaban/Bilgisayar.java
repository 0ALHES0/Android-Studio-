package com.example.secondprojected.Veritaban;

public class Bilgisayar  {
    int id;
    int envno;
    String marka;
    String model;
    String islemci;
    String ram;
    String hdd;

    public Bilgisayar() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getIslemci() {
        return islemci;
    }

    public void setIslemci(String islemci) {
        this.islemci = islemci;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getHdd() {
        return hdd;
    }

    public void setHdd(String hdd) {
        this.hdd = hdd;
    }
    public int getEnvno() {
        return envno;
    }

    public void setEnvno(int envno) {
        this.envno = envno;
    }
}