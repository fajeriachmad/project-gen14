import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
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

        // mengurutkan array products berdasarkan atribut harga
        for (int i = 0; i < products.length; i++) {
            for (int j = i + 1; j < products.length; j++) {
                DaftarBarang temp = new DaftarBarang();
                if (products[i].harga > products[j].harga) {
                    temp = products[i];
                    products[i] = products[j];
                    products[j] = temp;
                }
            }
        }

        Scanner input = new Scanner(System.in);
        int budget = input.nextInt();
        int minDiff = Integer.MAX_VALUE;
        int index = -1;

        for (int i = 0; i < products.length; i++) {
            int diff = budget - products[i].harga;
            if (diff <= minDiff && diff >= 0) {
                minDiff = diff;
                index = i;
            }
        }

        if (index >= 0) System.out.println(products[index]);
        else System.out.println("Budget anda tidak mencukupi");
    }
}
