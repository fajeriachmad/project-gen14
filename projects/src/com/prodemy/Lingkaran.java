package com.prodemy;

public class Lingkaran {
	private double r, luas, keliling;
	public String namaBangunDatar = "Lingkaran";
	// set nilai jari-jari
	public void setR(double r) {
		this.r = r;
	}
	// fungsi untuk menampilkan luas
	public double getLuas() {		
		if ((int)this.r % 7 == 0)
			luas = (double)22 / (double)7 * r * r;
		else
			luas = 3.14D * r * r;
		return luas;			
	}
	// fungsi untuk menampilkan keliling
	public double getKeliling() {
		if ((int)this.r % 7 == 0)
			keliling = (double)22 / (double)7 * 2 * r;
		else 
			keliling = 3.14D * 2 * r;
		return keliling;
	}
}
