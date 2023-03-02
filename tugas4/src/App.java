import com.gudang.Barang;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class App {
    public static void main(String[] args) throws Exception {
        // instansiasi barang
        Barang[] products = new Barang[] {
            new Barang("Oreo", 5000, 10),
            new Barang("Pocky", 3000, 15),
            new Barang("Regal", 8000, 7),
            new Barang("GuriBee", 7500, 19)
        };



        // ==== pengecekan file untuk menyimpan object ====
        try {
            File catatBarang = new File("daftarbarang.txt");
            if (catatBarang.createNewFile()) {
                System.out.println("Berhasil membuat file : " + catatBarang.getName());
            }
            else {
                System.out.println("File sudah tersedia dan siap digunakan.");
            }
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan.");
            e.printStackTrace();
        }

        // ==== menulis object pada file yang sudah disediakan ====
        try {
            // ==== menulis object ke daftarbarang.txt sebagai output ====            
            FileOutputStream f = new FileOutputStream("daftarbarang.txt");
            ObjectOutputStream o = new ObjectOutputStream(f);

            for (Barang barang : products) {
                o.writeObject(barang);
            }

            // menghentikan output stream
            o.close();
            f.close();

            // ==== membaca file daftarbarang.txt sebagai input
            FileInputStream fi = new FileInputStream("daftarbarang.txt");
            ObjectInputStream oi = new ObjectInputStream(fi);
            
            for (Barang barang : products) {
                Barang output = (Barang) oi.readObject();
                System.out.println(output.toString());
            }

            // menghentikan input stream
            oi.close();
            fi.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error menjalankan stream");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        
    }
}
