import java.util.Arrays;
import java.util.HashMap;

public class RomanNumber {
    enum Number {
        I(1), II(2), III(3), IV(4), V(5), VI(6), VII(7), VIII(8), IX(9), X(10);

        private final int num;

        int getNum() { return num;}

        Number(int num) {
            this.num = num;
        }
    }

    static String inputNames = "I, II, III, IV, V, VI, VII, VIII, IX, X";
    public static HashMap<Integer, String> romanNumbers = new HashMap<>();

    static {
        romanNumbers.put(0, "nulla");
        romanNumbers.put(1, "I");
        romanNumbers.put(2, "II");
        romanNumbers.put(3, "III");
        romanNumbers.put(4, "IV");
        romanNumbers.put(5, "V");
        romanNumbers.put(6, "VI");
        romanNumbers.put(7, "VII");
        romanNumbers.put(8, "VIII");
        romanNumbers.put(9, "IX");
        romanNumbers.put(10, "X");
        romanNumbers.put(20, "XX");
        romanNumbers.put(30, "XXX");
        romanNumbers.put(40, "XL");
        romanNumbers.put(50, "L");
        romanNumbers.put(60, "LX");
        romanNumbers.put(70, "LXX");
        romanNumbers.put(80, "LXXX");
        romanNumbers.put(90, "XC");
        romanNumbers.put(100, "C");
    }

    public static String convert(int n) {
        StringBuilder answer = new StringBuilder();
        if (n < 0) {
            answer.append("-");
            n = n * (-1);
        }

        if ((n % 10) == 0) { return romanNumbers.get(n); }
        else {
            if ((n / 10) == 0) { return answer.append(romanNumbers.get(n)).toString(); }
            else {
                int ones = n % 10;
                int dec = (n / 10) * 10;
                answer.append(romanNumbers.get(dec));
                answer.append(romanNumbers.get(ones));
                return answer.toString();
            }
        }
    }
}
