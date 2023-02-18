package com.prodemy;

import java.util.Iterator;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		// inisiasi array untuk menyimpan luas
		double[] barangs = new double[10];
		
		Scanner input = new Scanner(System.in);
        String action1, action2;
        double temp1, temp2, temp3;

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
                		validation(temp1);
                    	validation(temp2);
                	}
                	catch (Exception e){
                		e.printStackTrace();
                		continue;
                	}
                	
                	// memanggil class segitiga sama kaki
                	SegitigaSamaKaki s = new SegitigaSamaKaki();
                	s.setAlasTinggi(temp1, temp2);
                	System.out.println("Luas = " + s.getLuas());
                	System.out.println("Keliling = " + s.getKeliling());
                	barangs[i] = s.getLuas();
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
                		validation(temp1);
                    	validation(temp2);
                    	validation(temp3);
                	}
                	catch (Exception e){
                		e.printStackTrace();
                		continue;
                	}
                	
                	// memanggil class segitiga sembarang
                	SegitigaSembarang s = new SegitigaSembarang();
                	s.setABC(temp1, temp2, temp3);
                	System.out.println("Luas = " + s.getLuas());
                	System.out.println("Keliling = " + s.getKeliling());
                	barangs[i] = s.getLuas();
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
                		validation(temp1);
                    	validation(temp2);
                	}
                	catch (Exception e){
                		e.printStackTrace();
                		continue;
                	}
                	
                	// memanggil class segitiga siku
                	SegitigaSiku s = new SegitigaSiku();
                	s.setAlasTinggi(temp1, temp2);
                	System.out.println("Luas = " + s.getLuas());
                	System.out.println("Keliling = " + s.getKeliling());
                	barangs[i] = s.getLuas();
                	i++;
                }
                
                // kembali ke loop
                else if (action2.equalsIgnoreCase("0")) continue;
                
                // 
                else {
                    System.out.println("Undefined command ||Segitiga||");
                }
//                continue;
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
            	Persegi s = new Persegi();
            	s.setSisi(temp1);
            	System.out.println("Luas = " + s.getLuas());
            	System.out.println("Keliling = " + s.getKeliling());
            	barangs[i] = s.getLuas();
            	i++;
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
            	
            	// inisiasi class persegi
            	Lingkaran s = new Lingkaran();
            	s.setR(temp1);
            	System.out.println("Luas = " + s.getLuas());
            	System.out.println("Keliling = " + s.getKeliling());
            	barangs[i] = s.getLuas();
            	i++;
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
            	
            	// inisiasi class belah ketupat
            	BelahKetupat s = new BelahKetupat();
            	// set diagonal
            	s.setDiagonal(temp1, temp2);
            	System.out.println("Luas = " + s.getLuas());
            	System.out.println("Keliling = " + s.getKeliling());
            	barangs[i] = s.getLuas();
            	i++;

            } 
            
            // menampilkan array yang menyimpan luas
            else if (action1.equalsIgnoreCase("5")) {
            	System.out.println("Luas tersimpan (Max 10)");
            	for (int j = 0; j < barangs.length; j++) {
                    System.out.println(barangs[j]);
        		}
        	} else if (action1.equalsIgnoreCase("0")){
                System.exit(0);
            } else {
                System.out.println("Undefined command");
            }
        }
        
	}
	
	private static double validation(double x) throws Exception {
		if (x > 0) {
			return x;
		}
		else {
			throw new Exception("Tidak boleh negatif.");
		}
	}

}
