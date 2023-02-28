package com.prodemy;

public class Persegi extends BangunDatar {
	private double sisi, luas, keliling;
	public String namaBangunDatar = "Persegi";

	/**
	 * Deklarasi constructor.
	 * 
	 */
	public Persegi() {}
	public Persegi(double sisi) {
		this.sisi = sisi;
	}
	
	public void setSisi(double sisi) {
		this.sisi = sisi;
	}
	
	@Override
	public double getLuas() {
		luas = sisi * sisi;
		return luas;
	}

	@Override
	public double getKeliling() {
		keliling = 4 * sisi;
		return keliling;
	}

	public String getKeterangan() {
		return "Sisi : " + this.sisi;
	}
}
