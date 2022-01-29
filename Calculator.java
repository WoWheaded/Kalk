package myKalk;

import java.util.Scanner;
import static myKalk.Calculate.*;


public class Calculator {
    public static void main(String[] args) throws Exception {
        Calculate calc1 = new Calculate();
        System.out.println("Введите выражение формата 2 + 2, только арабскими или только римскими числами в диапазоне от 1 до 10 ");
        Scanner scanInput = new Scanner(System.in);
        String expression = scanInput.nextLine();
        String[] expressionMassive = expression.split(" ");
        String operation = expressionMassive[1];
        boolean verification = arabic_or_roman(expression);
        if (expressionMassive.length != 3) {
            throw new Exception("Неверный формат вводимого выражения");
        }
        if (verification) {
            if (operation.equals("+")) System.out.println(integerToRomanNumeral(romanToInteger(expressionMassive[0]) + (romanToInteger(expressionMassive[2]))));
            if (operation.equals("-")) System.out.println(integerToRomanNumeral(romanToInteger(expressionMassive[0]) - (romanToInteger(expressionMassive[2]))));
            if (operation.equals("*")) System.out.println(integerToRomanNumeral(romanToInteger(expressionMassive[0]) * (romanToInteger(expressionMassive[2]))));
            if (operation.equals("/")) System.out.println(integerToRomanNumeral(romanToInteger(expressionMassive[0]) / (romanToInteger(expressionMassive[2]))));
        } else {
            int num1 = Integer.parseInt(expressionMassive[0]);
            int num2 = Integer.parseInt(expressionMassive[2]);
            calc1.calculateArabic(num1, num2, operation);
        }
    }
}
