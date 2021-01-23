public class Validator {
    public static void check(String[] ex) throws Exception {
        if (ex[3].equals("dec")) {
            checkDecimalNumbers(ex[0], ex[1]);
        }
        else if (ex[3].equals("rom")) {
            checkRomanNumber(ex[0]);
            checkRomanNumber(ex[1]);
        }
        else throw new Exception("Invalid operation");
        checkOperation(ex[2]);
    }

    private static void checkOperation(String op) throws Exception {
        if (!(op.length() == 1 && op.matches("[+\\-*/]"))) throw new Exception("Invalid operation");
    }

    private static void checkDecimalNumbers(String num1, String num2) throws Exception {
        int a = Integer.parseInt(num1);
        int b = Integer.parseInt(num2);

        if(a < 1 || a > 10) throw new Exception("Invalid value");
        if(b < 1 || b > 10) throw new Exception("Invalid value");
    }

    private static void checkRomanNumber(String n) throws Exception {
        if (!(RomanNumber.inputNames.contains(n))) throw new Exception("Invalid value");
    }
}