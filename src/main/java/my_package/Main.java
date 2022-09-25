package my_package;

import my_package.calculations.ArabicCalcs;
import my_package.calculations.RomanCalcs;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        String row = reader.nextLine();
        int result;

        try {
            if (NumberIdentifier.isArabicNumber(row)) {
                ArabicCalcs calcs = new ArabicCalcs(row);
                System.out.println(calcs.calculate());
            }
            else if (NumberIdentifier.isRomanNumber(row)) {
                RomanCalcs calcs = new RomanCalcs(row);
                result = calcs.calculate();
                System.out.println(calcs.intToRoman(result));
            }
            else {
                System.out.println("Неверный формат чисел");
            }
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}