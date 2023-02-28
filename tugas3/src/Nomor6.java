import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Nomor6 {
    static List<Character> vocals = Arrays.asList('a', 'i', 'u', 'e', 'o');

    public static boolean isVocal(char arg) {
        for (int i = 0; i < vocals.size(); i++) {
            if (arg == vocals.get(i)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        List<Integer> totalPerVocal = Arrays.asList(0, 0, 0, 0, 0);
        // index List totalPerVocal menyesuaikan index List vocals
        // sehingga totalPerVocal[0] = vocals[0]

        System.out.print("Input sentence : ");
        Scanner input = new Scanner(System.in);
        String s = input.nextLine().toLowerCase();
        
        for (int i = 0; i < s.length(); i++) {
            if (isVocal(s.charAt(i))) {
                // mendapatkan index dari huruf vokal
                int pos = vocals.indexOf(s.charAt(i));
                int value = totalPerVocal.get(pos);
                // increment jumlah karakter berdasarkan index pos
                value++;
                // update nilai hasil increment ke totalPerVocal berdasarkan index pos
                totalPerVocal.set(pos, value);
            }
        }

        // output
        for (int i = 0; i < vocals.size(); i++) {
            System.out.println(vocals.get(i) + " = " + totalPerVocal.get(i));
        }

    }
}
