public class ExpressionRecognizer {

    public static String[] recognize(String s) {
        String stringWithNumbers = s.replaceAll("(\\W)+", " ");
        String a = stringWithNumbers.replaceAll("[\\s].+", "");
        String b = stringWithNumbers.replaceAll(".+[\\s]", "");
        String typeOfNumbers = "?";

        String operation = s.replaceAll("[\\s\\w]*", "");

        if (a.matches("\\d*") && b.matches("\\d*")) {
            typeOfNumbers = "dec";
        }
        else if (a.matches("[IVX]+") && b.matches("[IVX]+")) {
            typeOfNumbers = "rom";
        }

        return new String[] {a, b, operation, typeOfNumbers};
    }
}
