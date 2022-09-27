package my_package;

import my_package.calculations.ArabicCalcs;
import my_package.calculations.Calculations;
import my_package.calculations.RomanCalcs;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        String row = reader.nextLine();
        row = row.trim();
        int result;

        try {
            if (NumberIdentifier.isArabicNumber(row)) {
                Calculations calcs = new ArabicCalcs(row);
                result = calcs.calculate();
                System.out.println(result);
            }
            else if (NumberIdentifier.isRomanNumber(row)) {
                RomanCalcs calcs = new RomanCalcs(row);
                result = calcs.calculate();
                if(result > 0){
                    System.out.println(calcs.intToRoman(result));
                }else{
                    System.out.println("Неположительный результат");
                }
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