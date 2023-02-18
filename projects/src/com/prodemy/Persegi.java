package com.prodemy;

public class Persegi extends BangunDatar {
	private double sisi, luas, keliling;
	public Persegi() {}
	public String namaBangunDatar = "Persegi";
	
	public void setSisi(double sisi) {
		this.sisi = sisi;
	}
	
	public double getLuas() {
		luas = sisi * sisi;
		return luas;
	}

	public double getKeliling() {
		keliling = 4 * sisi;
		return keliling;
	}
}
