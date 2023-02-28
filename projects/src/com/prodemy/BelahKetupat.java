package com.prodemy;

import java.security.Timestamp;

public class BelahKetupat extends BangunDatar {
	private double d1, d2, s;
	public String namaBangunDatar = "Belah Ketupat";
	
	// constructor
	public BelahKetupat() {}
	public BelahKetupat(double d1, double d2) {
		this.d1 = d1;
		this.d2 = d2;
	}
	
	public void setDiagonal(double d1, double d2) {
		this.d1 = d1;
		this.d2 = d2;
	}
	
	@Override
	public double getLuas() {
		luas = d1 * d2 / 2D;
		return luas;
	}
	
	@Override
	public double getKeliling() {
		s = Math.sqrt(d1 * d1 / 4D + d2 * d2 / 4D );
		keliling = 4 * s;
		return keliling;
	}

	public String getKeterangan() {
		return 
		"D1 : " + this.d1 + 
		"\nD2 : " + this.d2;
	}
}
