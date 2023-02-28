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

        Scanner input = new Scanner(System.in);
        String s = input.nextLine().toLowerCase();
        
        for (int i = 0; i < s.length(); i++) {
            if (isVocal(s.charAt(i))) {
                int pos = vocals.indexOf(s.charAt(i));
                int value = totalPerVocal.get(pos);
                value++;
                totalPerVocal.set(pos, value);
            }
        }

        for (int i = 0; i < vocals.size(); i++) {
            System.out.println(vocals.get(i) + " = " + totalPerVocal.get(i));
        }

    }
}
