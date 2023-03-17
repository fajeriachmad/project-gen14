package com.prodemy.web.model;

public class Dosen {
	protected int id;
	protected String nama;

	public Dosen() {}
	
	public Dosen(String nama) {
		super();
		this.nama = nama;
	}

	public Dosen(int id, String nama) {
		super();
		this.id = id;
		this.nama = nama;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	@Override
	public String toString() {
		return "Dosen [id=" + id + ", nama=" + nama + "]";
	}
	
	
}
