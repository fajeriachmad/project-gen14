package com.prodemy;

public class BelahKetupat {
	private double d1, d2, s, luas, keliling;
	public void BelahKetupat() {}
	
	public void setDiagonal(double d1, double d2) {
		this.d1 = d1;
		this.d2 = d2;
	}
	
	public double getLuas() {
		luas = d1 * d2 / 2D;
		return luas;
	}
	
	public double getKeliling() {
		s = Math.sqrt(d1 * d1 / 4D + d2 * d2 / 4D );
		keliling = 4 * s;
		return keliling;
	}
}
