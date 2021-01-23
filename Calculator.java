import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Calculator {

    public static void main(String[] args) throws Exception {
        String[] recognizedEx = new String[3];
        int a = 0;
        int b = 0;

        try (InputStreamReader isr = new InputStreamReader(System.in);
             BufferedReader reader = new BufferedReader(isr)) {

            String ex = reader.readLine();

            recognizedEx = ExpressionRecognizer.recognize(ex);
            Validator.check(recognizedEx);

        } catch (IOException e) { e.printStackTrace(); }

        if (recognizedEx[3].equals("dec")) {
            a = Integer.parseInt(recognizedEx[0]);
            b = Integer.parseInt(recognizedEx[1]);
        }
        else if (recognizedEx[3].equals("rom")) {
            a = RomanNumber.Number.valueOf(recognizedEx[0]).getNum();
            b = RomanNumber.Number.valueOf(recognizedEx[1]).getNum();
        }

        switch (recognizedEx[2]) {
            case "+": {
                if (recognizedEx[3].equals("dec")) System.out.println(summation(a, b));
                else System.out.println(RomanNumber.convert(summation(a, b)));
            }
            break;

            case "-": {
                if (recognizedEx[3].equals("dec")) System.out.println(subtraction(a, b));
                else System.out.println(RomanNumber.convert(subtraction(a, b)));
            }
            break;

            case "*": {
                if (recognizedEx[3].equals("dec")) System.out.println(multiplication(a, b));
                else System.out.println(RomanNumber.convert(multiplication(a, b)));
            }
            break;

            case "/": {
                if (recognizedEx[3].equals("dec")) System.out.println(division(a, b));
                else System.out.println(RomanNumber.convert(division(a, b)));
            }
            break;
        }
    }

    private static int summation(int a, int b) {
        return a + b;
    }

    private static int subtraction(int a, int b) {
        return a - b;
    }

    private static int multiplication(int a, int b) {
        return a * b;
    }

    private static int division(int a, int b) {
        return a / b;
    }
}
