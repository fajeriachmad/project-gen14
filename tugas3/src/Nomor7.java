import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import javax.rmi.ssl.SslRMIClientSocketFactory;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

public class Nomor7 {
    public static void main(String[] args) {
        // instansiasi array products
        DaftarBarang[] products = new DaftarBarang[] {
            new DaftarBarang("Oreo", 6000),
            new DaftarBarang("Tanggo", 5000),
            new DaftarBarang("Buavita", 7000),
            new DaftarBarang("Aqua", 3000)
        };

        // mengurutkan array products berdasarkan atribut harga terbesar
        for (int i = 0; i < products.length; i++) {
            for (int j = i + 1; j < products.length; j++) {
                DaftarBarang temp = new DaftarBarang();
                if (products[i].getHarga() < products[j].getHarga()) {
                    temp = products[i];
                    products[i] = products[j];
                    products[j] = temp;
                }
            }
        }
        
        // input untuk budget
        Scanner input = new Scanner(System.in);
        int budget = input.nextInt();

        // deklarasi list untuk menampung daftar harga yang bisa dibeli
        List<Integer> result = new ArrayList<>();
        boolean isNotEnough = true; // flag budget
        int jumlahBarang = 0;
        while (isNotEnough) {
            for (int i = 0; i < products.length; i++) {
                if (budget - products[i].getHarga() >= 0) {
                    budget -= products[i].getHarga();
                    result.add(products[i].getHarga());
                    jumlahBarang++;
                    break;
                }
                // jika tidak ada barang yang bisa dibeli, maka hentika while loop
                else isNotEnough = false;
            }
        }
        // jika ada barang yang bisa dibeli, maka tampilkan barang tersebut
        if (jumlahBarang > 0) {
            System.out.println("Anda dapat membeli item(s) terbaik : ");
            for (int i = 0; i < result.size(); i++) {
                for (int j = 0; j < products.length; j++) {
                    if (result.get(i) == products[j].getHarga()) {
                        System.out.println(products[j]);
                    }
                }
            }
        }
        // jika tidak ada barang yang bisa dibeli, tampilkan budget tidak mencukupi
        else {
            System.out.println("Budget anda tidak mencukupi untuk membeli item apapun.");
        }
    }
}
