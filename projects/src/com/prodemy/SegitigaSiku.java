package com.prodemy;

import java.lang.Math;

public class SegitigaSiku extends BangunDatar {
	private double a, t, luas, keliling;
	public String namaBangunDatar = "Segitiga Siku-siku";
	
	// constructor
	public SegitigaSiku () {}
	public SegitigaSiku (double a, double t) {
		this.a = a;
		this.t = t;
	}
	
	// method set alas dan tinggi
	public void setAlasTinggi(double a, double t) {
		this.a = a;
		this.t = t;
	}
		
	@Override
	public double getLuas() {
		luas = a * t / (double)2;
		return luas;
	}
	
	// keliling untuk segitiga siku-siku
	@Override
	public double getKeliling() {
		double c = Math.sqrt(a * a + t * t);
		keliling = a + t + c;
		return keliling;
	}

	public String getKeterangan() {
		return 
			"Alas : " + this.a + 
			"\nTinggi : " + this.t;
	}
}
