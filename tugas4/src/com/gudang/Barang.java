package com.gudang;

import java.io.Serializable;

public class Barang implements Serializable{
    private static final long serialVersionUID = 1L;
    private String nama;
    private int harga;
    private int persediaan;

    public Barang() {}
    public Barang(String nama, int harga, int persediaan) {
        super();
        this.nama = nama;
        this.harga = harga;
        this.persediaan = persediaan;
    }

    public String getNama() {
        return nama;
    }

    public int getHarga() {
        return harga;
    }

    public int getPersediaan() {
        return persediaan;
    }

    @Override
    public String toString() {
        return "Produk : " + nama + "\nHarga : " + harga + "\nPersediaan : " + persediaan;
    }
}
