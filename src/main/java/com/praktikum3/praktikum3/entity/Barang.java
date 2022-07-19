package com.praktikum3.praktikum3.entity;

public class Barang {
    private int id;
    private String nama;
    private String supplier;

    public Barang(int id, String nama, String supplier) {
        this.id = id;
        this.nama = nama;
        this.supplier = supplier;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }
}
