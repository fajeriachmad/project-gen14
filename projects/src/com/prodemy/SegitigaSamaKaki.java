package com.prodemy;

public class SegitigaSamaKaki {
	private double a, t, luas, keliling;
	public String namaBangunDatar = "Segitiga Sama Kaki";
	public SegitigaSamaKaki() {
		super();
	}
	
	// method set alas dan tinggi
	public void setAlasTinggi(double a, double t) {
		this.a = a;
		this.t = t;
	}
	// method untuk mencari luas
	public double getLuas() {
		luas = a * t / (double)2;
		return luas;
	}
	// method untuk mencari keliling
	public double getKeliling() {
		double c = Math.sqrt(a * a / 4 + t * t);
		keliling = a + c + c;
		return keliling;
	}
}
