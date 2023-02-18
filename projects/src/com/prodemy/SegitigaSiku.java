package com.prodemy;

import java.lang.Math;

public class SegitigaSiku {
	private double a, t, luas, keliling;
	
	public String namaBangunDatar = "Segitiga";
	// segitiga sama kaki / sama siku-siku
	
	// method set alas dan tinggi
		public void setAlasTinggi(double a, double t) {
			this.a = a;
			this.t = t;
	}
		
	public float getLuas() {
		luas = a * t / (float)2;
		return (float)luas;
	}
	
	// keliling untuk segitiga siku-siku
	public double getKeliling() {
		double c = Math.sqrt(a * a + t * t);
		keliling = a + t + c;
		return keliling;
	}
}
