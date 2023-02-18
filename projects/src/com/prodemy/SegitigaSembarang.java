package com.prodemy;

public class SegitigaSembarang {
	private double a, b, c, luas, keliling;
	
	// method untuk set sisi a, b dan c
	public void setABC(double a, double b, double c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
	// method untuk menampilkan luas segitiga sembarang
	public double getLuas() {
		double s = (a + b + c) / (double)2;
		luas = Math.sqrt(s * ( s - a ) * ( s - b ) * ( s - c ));
		return luas; 
	}
	
	// method untuk menampilkan keliling segitiga
	public double getKeliling() {
		keliling = a + b + c;
		return keliling;
	}
}
