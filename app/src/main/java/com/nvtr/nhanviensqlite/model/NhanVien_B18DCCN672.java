package com.nvtr.nhanviensqlite.model;

public class NhanVien_B18DCCN672 {
    int ma;
    String name;
    String namsinh;
    String quequan;
    String trinhdo;
    public NhanVien_B18DCCN672(){

    }
    public NhanVien_B18DCCN672(int ma, String name, String namsinh, String quequan, String trinhdo) {
        this.ma = ma;
        this.name = name;
        this.namsinh = namsinh;
        this.quequan = quequan;
        this.trinhdo = trinhdo;
    }
    public NhanVien_B18DCCN672( String name, String namsinh, String quequan, String trinhdo) {
        this.name = name;
        this.namsinh = namsinh;
        this.quequan = quequan;
        this.trinhdo = trinhdo;
    }

    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNamsinh() {
        return namsinh;
    }

    public void setNamsinh(String namsinh) {
        this.namsinh = namsinh;
    }

    public String getQuequan() {
        return quequan;
    }

    public void setQuequan(String quequan) {
        this.quequan = quequan;
    }

    public String getTrinhdo() {
        return trinhdo;
    }

    public void setTrinhdo(String trinhdo) {
        this.trinhdo = trinhdo;
    }



}
