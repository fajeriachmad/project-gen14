package com.prodemy;

// import java.util.Iterator;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		// inisiasi object bangun datar untuk menyimpan nilai luas
		
		// double[] myLuasArray = new double[10];
		BangunDatar[] bangunDatar = new BangunDatar[10];
		// deklarasi variable bantuan
        String action1, action2;
        double temp1, temp2, temp3;

		
		// interface untuk menampilkan opsi
        int i = 0;
        while (true) {
            System.out.println("=== APLIKASI INTERFACE MENCARI LUAS DAN KELILING ===");
            System.out.println("[1] SEGITIGA");
            System.out.println("[2] PERSEGI");
            System.out.println("[3] LINGKARAN");
            System.out.println("[4] BELAH KETUPAT");
            System.out.println("[5] TAMPILKAN LUAS");
            System.out.println("[0] Keluar");
            System.out.println("====================================================");
            System.out.print("Pilih > ");
            Scanner input = new Scanner(System.in);
            action1 = input.nextLine();
            
            // opsi segitiga
            if(action1.equalsIgnoreCase("1")){
            	System.out.println("=== Segitiga ===");
                System.out.println("[1] Segitiga Sama Kaki");
                System.out.println("[2] Segitiga Sama Sisi / Sembarang");
                System.out.println("[3] Segitiga Siku-siku");
                System.out.println("[0] Kembali");
                System.out.println("Tipe Segitiga? (1/2/3)");
                action2 = input.nextLine();
                
                // segitiga sama kaki
                if (action2.equalsIgnoreCase("1")) {
                	System.out.println("=== Segitiga Sama Kaki ===");
                	System.out.print("Alas = ");
                	temp1 = input.nextDouble();
                	System.out.print("Tinggi = ");
                	temp2 = input.nextDouble();
                	
                	// validasi jika input bernilai negatif maka kembali ke looping
                	try {
                		validation(temp1, temp2);
                	}
                	catch (Exception e){
                		e.printStackTrace();
                		continue;
                	}
                	
                	// instansiasi object segitiga sama kaki
                	SegitigaSamaKaki bangun = new SegitigaSamaKaki(temp1, temp2);
                	System.out.println("Luas = " + bangun.getLuas());
                	System.out.println("Keliling = " + bangun.getKeliling());
					bangunDatar[i] = bangun;
					// bangun.setLuas(bangun.getLuas());
					// myLuasArray[i] = bangun.luas;
                	// bangunDatar[i] = new BangunDatar(bangun.namaBangunDatar, bangun.getLuas(), bangun.getKeterangan());
					// bangunDatar[i].setNama(s.namaBangunDatar);
					// bangunDatar[i].setLuas(s.getLuas());
					// bangunDatar[i].setKeterangan(s.getKeterangan());
                	i++;
                } 
                // segitiga sembarang / sama sisi
                else if (action2.equalsIgnoreCase("2")) {
                	System.out.println("=== Segitiga Sembarang / Sama Sisi ===");
                	System.out.print("Sisi 1 = ");
                	temp1 = input.nextDouble();
                	System.out.print("Sisi 2 = ");
                	temp2 = input.nextDouble();
                	System.out.print("Sisi 3 = ");
                	temp3 = input.nextDouble();
                	
                	// validasi jika input bernilai negatif maka kembali ke looping
                	try {
						validation(temp1, temp2, temp3);
                	}
                	catch (Exception e){
                		e.printStackTrace();
                		continue;
                	}
                	
					
                	// memanggil class segitiga sembarang
                	SegitigaSembarang bangun = new SegitigaSembarang(temp1, temp2, temp3);
					System.out.println("Luas = " + bangun.getLuas());
                	System.out.println("Keliling = " + bangun.getKeliling());
                	// bangunDatar[i] = new BangunDatar(bangun.namaBangunDatar, bangun.getLuas(), bangun.getKeterangan());
                	bangunDatar[i] = bangun;
					// System.out.println("Luas = " + segitiga.getLuas());
                	// System.out.println("Keliling = " + segitiga.getKeliling());
					// bangunDatar[i] = new BangunDatar(segitiga.namaBangunDatar, segitiga.getLuas(), segitiga.getKeterangan());
					// constructor tanpa parameter
                	// bangunDatar[i] = new BangunDatar();
					// bangunDatar[i].setNama(s.namaBangunDatar);
					// bangunDatar[i].setLuas(s.getLuas());
					// bangunDatar[i].setKeterangan(s.getKeterangan());
					
					// constructor dengan parameter

                	i++;
                } 
                
                // segitiga siku
                else if (action2.equalsIgnoreCase("3")) {
                	System.out.println("=== Segitiga Siku-siku ===");
                	System.out.print("Alas = ");
                	temp1 = input.nextDouble();
                	System.out.print("Tinggi = ");
                	temp2 = input.nextDouble();
                	
                	// validasi jika input bernilai negatif maka kembali ke looping
                	try {
						validation(temp1, temp2);
                	}
                	catch (Exception e){
						e.printStackTrace();
                		continue;
                	}
                	
                	// instansiasi object segitiga siku pada constructor TANPA parameter
					// instansiasi menggunakan setter
                	// SegitigaSiku s = new SegitigaSiku();
                	// s.setAlasTinggi(temp1, temp2);
                	// System.out.println("Luas = " + s.getLuas());
                	// System.out.println("Keliling = " + s.getKeliling());

					// instansiasi object segitiga siku pada constructor DENGAN parameter
					SegitigaSiku bangun = new SegitigaSiku(temp1, temp2);
					System.out.println("Luas = " + bangun.getLuas());
                	System.out.println("Keliling = " + bangun.getKeliling());
                	// bangunDatar[i] = new BangunDatar(bangun.namaBangunDatar, bangun.getLuas(), bangun.getKeterangan());
					bangunDatar[i] = bangun;
					// System.out.println("Luas = " + segitiga.getLuas());
					// System.out.println("Keliling = " + segitiga.getKeliling());
					// bangunDatar[i] = new BangunDatar(segitiga.namaBangunDatar, segitiga.getLuas(), segitiga.getKeterangan());
                	// bangunDatar[i] = new BangunDatar();
					// bangunDatar[i].setNama(s.namaBangunDatar);
					// bangunDatar[i].setLuas(s.getLuas());
					// bangunDatar[i].setKeterangan(s.getKeterangan());
                	i++;
                }
                
                // kembali ke loop
                else if (action2.equalsIgnoreCase("0")) continue;
                
                // 
                else {
                    System.out.println("Undefined command ||Segitiga||");
                }
                // input.reset();
            } 
            
            // opsi persegi
            else if (action1.equalsIgnoreCase("2")){
            	System.out.println("=== Persegi ===");
            	System.out.print("Sisi = ");
            	temp1 = input.nextDouble();
            	
            	// validasi jika input bernilai negatif maka kembali ke looping
            	try {
            		validation(temp1);
            	}
            	catch (Exception e){
            		e.printStackTrace();
            		continue;
            	}
            	
            	// inisiasi class persegi
            	Persegi bangun = new Persegi(temp1);
				System.out.println("Luas = " + bangun.getLuas());
				System.out.println("Keliling = " + bangun.getKeliling());
				bangunDatar[i] = new BangunDatar(bangun.namaBangunDatar, bangun.getLuas(), bangun.getKeterangan());
            	// System.out.println("Luas = " + s.getLuas());
            	// System.out.println("Keliling = " + s.getKeliling());
            	// bangunDatar[i] = new BangunDatar();
				// bangunDatar[i].setNama(s.namaBangunDatar);
				// bangunDatar[i].setLuas(s.getLuas());
				// bangunDatar[i].setKeterangan(s.getKeterangan());
            	i++;
            	// input.reset();
            } 
            
            // opsi lingkaran
            else if (action1.equalsIgnoreCase("3")){
            	System.out.println("=== Lingkaran ===");
            	System.out.print("Jari-jari = ");
            	temp1 = input.nextDouble();
            	
            	// validasi jika input bernilai negatif maka kembali ke looping
            	try {
            		validation(temp1);
            	}
            	catch (Exception e){
            		e.printStackTrace();
            		continue;
            	}
            	
            	// inisiasi object lingkaran
            	Lingkaran s = new Lingkaran(temp1);
            	// s.setR(temp1);
            	System.out.println("Luas = " + s.getLuas());
            	System.out.println("Keliling = " + s.getKeliling());
            	bangunDatar[i] = new BangunDatar();
				bangunDatar[i].setNama(s.namaBangunDatar);
				bangunDatar[i].setLuas(s.getLuas());
				bangunDatar[i].setKeterangan(s.getKeterangan());
            	i++;
            	// input.reset();
            } 
            
            // opsi belah ketupat
            else if (action1.equalsIgnoreCase("4")){
            	System.out.println("=== Belah Ketupat ===");
            	System.out.print("Diagonal 1 = ");
            	temp1 = input.nextDouble();
            	System.out.print("Diagonal 2 = ");
            	temp2 = input.nextDouble();
            	
            	// validasi jika input bernilai negatif maka kembali ke looping
            	try {
            		validation(temp1);
            		validation(temp1);
            	}
            	catch (Exception e){
            		e.printStackTrace();
            		continue;
            	}
            	
            	// inisiasi object belah ketupat
            	BelahKetupat s = new BelahKetupat();
            	// set diagonal
            	s.setDiagonal(temp1, temp2);
            	System.out.println("Luas = " + s.getLuas());
            	System.out.println("Keliling = " + s.getKeliling());
            	bangunDatar[i] = new BangunDatar();
				bangunDatar[i].setNama(s.namaBangunDatar);
				bangunDatar[i].setLuas(s.getLuas());
				bangunDatar[i].setKeterangan(s.getKeterangan());
            	i++;
            	// input.reset();
            } 
            
            // menampilkan array yang menyimpan luas
            else if (action1.equalsIgnoreCase("5")) {
            	System.out.println("Luas tersimpan (Max 10)");
            	for (int j = 0; j < bangunDatar.length; j++) {
                    System.out.println(bangunDatar[j]);
        		}
        	} else if (action1.equalsIgnoreCase("0")){
        		input.close();
                System.exit(0);
            } else {
                System.out.println("Undefined command");
            }
			input.reset();
        }
        
		
	}
	
	/** 
	 * fungsi ini digunakan untuk validate input
	 * apakah input bernilai positif atau negatif.
	 * Jika input bernilai negatif, maka akan menampilkan
	 * exception
	 * @param x bertipe double
	 */

	private static double validation(double x) throws Exception {
		if (x > 0) {
			return x;
		}
		else {
			throw new Exception("Tidak boleh negatif.");
		}
	}

	private static double[] validation(double x, double y) throws Exception {
		if (x > 0 && y > 0) {
			double[] value = new double[2];
			value[0] = x;
			value[1] = y;
			return value;
		}
		else {
			throw new Exception("Input tidak boleh negatif.");
		}
	}

	private static double[] validation(double x, double y, double z) throws Exception {
		if (x > 0 && y > 0 && z > 0) {
			double[] value = new double[3];
			value[0] = x;
			value[1] = y;
			value[2] = z;
			return value;
		}
		else {
			throw new Exception("Input tidak boleh negatif.");
		}
	}

}
