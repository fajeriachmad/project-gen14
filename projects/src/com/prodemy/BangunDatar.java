package com.prodemy;

/** 
 * class BangunDatar adalah class parent berisi
 * sekumpulan method yang akan digunakan oleh
 * kelas child bangun datar
 */

public abstract class BangunDatar {

	// attributes
	private String namaBangunDatar, keterangan;
	public double luas, keliling;

	/**
	 * Constructor untuk object bangun datar.
	 * Ada dua jenis constructor, tanpa dan dengan parameter.
	 */
	public BangunDatar() {}

	
	public BangunDatar(String nama, double luas, String ket) {
		this.namaBangunDatar = nama;
		this.luas = luas;
		this.keterangan = ket;
	}
	
	
	/**
	 * method untuk inisiasi nama
	 * @param nama bangun datar child
	 */
	public void setNama(String nama) {
		this.namaBangunDatar = nama;
	}

	/**
	 * method untuk inisiasi luas
	 * @param luas bangun datar child
	 */

	public void setLuas(double luas) {
		this.luas = luas;
	}
	public void setKeliling(double keliling) {
		this.keliling = keliling;
	}
	
	public String getNama() {
		return namaBangunDatar;
	}
	
	public abstract double getLuas();

	public abstract double getKeliling();

	// overloading method untuk mendapatkan keterangan
	public void setKeterangan(String ket) {
		this.keterangan = ket;
	}

	public void show() {
		
	}

	@Override
	public String toString() {
		return 
			"Nama bangun : " + this.namaBangunDatar + "\n" + this.keterangan +
			"\nLuas : " + this.luas;
	}
}
