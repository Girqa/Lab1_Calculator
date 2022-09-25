package my_package;

public class NumberIdentifier {

    public static boolean isArabicNumber(String number){
        String charToString = String.valueOf(number.charAt(0));
        String allowedInts = "[123456789]";
        return charToString.matches(allowedInts);
    }

    public static boolean isRomanNumber(String number){
        String charToString = String.valueOf(number.charAt(0));
        String allowedRoms = "[IVX]";
        return charToString.matches(allowedRoms);
    }
}
