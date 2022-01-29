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
        boolean verification = arabic_or_roman(expression);
        if (expressionMassive.length != 3)  {
            throw new Exception("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }
        String operation = expressionMassive[1];
        if (verification) {
            if (operation.equals("+")) System.out.println(integerToRomanNumeral(romanToInteger(expressionMassive[0]) + (romanToInteger(expressionMassive[2]))));
            if (operation.equals("-")) System.out.println(integerToRomanNumeral(romanToInteger(expressionMassive[0]) - (romanToInteger(expressionMassive[2]))));
            if (operation.equals("*")) System.out.println(integerToRomanNumeral(romanToInteger(expressionMassive[0]) * (romanToInteger(expressionMassive[2]))));
            if (operation.equals("/")) System.out.println(integerToRomanNumeral(romanToInteger(expressionMassive[0]) / (romanToInteger(expressionMassive[2]))));
        } else {
            int num1 = Integer.parseInt(expressionMassive[0]);
            String romanExample = "IVXLC";
            if (romanExample.contains(expressionMassive[2]) && !expressionMassive[2].matches("(.*)(\\d+)(.*)")) {
                throw new Exception("Используются одновременно разные системы счисления");
            }
            int num2 = Integer.parseInt(expressionMassive[2]);
            calc1.calculateArabic(num1, num2, operation);
        }
    }
}
