package com.nvtr.nhanviensqlite.model;

public class NhanVienViTri_B18DCCN672 {
    int ma;
    int manv;
    int mavitri;
    String name;

    public NhanVienViTri_B18DCCN672(){

    }

    public NhanVienViTri_B18DCCN672(int ma, int manv, int mavitri, String name) {
        this.ma = ma;
        this.manv = manv;
        this.mavitri = mavitri;
        this.name = name;
    }

    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public int getManv() {
        return manv;
    }

    public void setManv(int manv) {
        this.manv = manv;
    }

    public int getMavitri() {
        return mavitri;
    }

    public void setMavitri(int mavitri) {
        this.mavitri = mavitri;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
