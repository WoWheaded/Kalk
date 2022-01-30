package myKalk;

public class Calculate extends Calculator {

    public void calculateArabic(int num1, int num2, String operation) throws Exception {
        int result = 0;
        if (num1 < 0 || num1 > 10 || num2 < 0 || num2 > 10) throw new Exception("Число должно быть от 1 до 10");
        result = switch (operation) {
            case "+" -> num1 + num2;
            case "-" -> num1 - num2;
            case "*" -> num1 * num2;
            case "/" -> num1 / num2;
            default -> throw new Exception("неверный знак операции");
        };
        System.out.println("Ответ = " + result);
    }
    //Берет первый символ из вводимой строки и ищет этот символ в строке римских числел romanExample, если находит одинаковый символ
    // и в строке отстутствуют числа (с помошью регулярных выражений), возвращает значение true и строка является полностью римским выражением.
    //Если символ не находится, то .indexOf возвращает значение -1, и если при этом в строке содержатся числа, то строка является полностью арабасским выражением.
    public static boolean arabic_or_roman(String expression) throws Exception {
        String romanExample = "IVXLC";
        if (romanExample.indexOf(expression.charAt(0)) != -1 && !expression.matches("(.*)(\\d+)(.*)"))
            return true;
        if (romanExample.indexOf(expression.charAt(0)) == -1 && expression.matches("(.*)(\\d+)(.*)"))
            return false;
        if (romanExample.indexOf(expression.charAt(0)) != -1 && expression.matches("(.*)(\\d+)(.*)"))
            throw new Exception("Используются одновременно разные системы счисления");
        return false;
    }

    // перевод одиночныйх основных римских символов в число
    public static int decodingRomanSingleChar(char romanChar) {
        return switch (romanChar) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            default -> 0;
        };
    }
    //перевод арабского числа в римский символ, если число <1 выбрасывается исключение
    public static String integerToRomanNumeral(int input) throws Exception {
        StringBuilder sb = new StringBuilder();
        if (input < 1) throw new Exception ("т.к. в римской системе нет отрицательных чисел");
        while (input >= 100) {
            sb.append("C");
            input -= 100;
        }
        while (input >= 90) {
            sb.append("XC");
            input -= 90;
        }
        while (input >= 50) {
            sb.append("L");
            input -= 50;
        }
        while (input >= 40) {
            sb.append("XL");
            input -= 40;
        }
        while (input >= 10) {
            sb.append("X");
            input -= 10;
        }
        while (input >= 9) {
            sb.append("IX");
            input -= 9;
        }
        while (input >= 5) {
            sb.append("V");
            input -= 5;
        }
        while (input >= 4) {
            sb.append("IV");
            input -= 4;
        }
        while (input >= 1) {
            sb.append("I");
            input -= 1;
        }
        return sb.toString();
    }

    //перевод римскиого символа в арабское число
    public static int romanToInteger(String IntegerToRomanNumeral) throws Exception {
        int result = 0;
        for (int i = 0; i < IntegerToRomanNumeral.length() - 1; i++) {
            if (decodingRomanSingleChar(IntegerToRomanNumeral.charAt(i)) < decodingRomanSingleChar(IntegerToRomanNumeral.charAt(i + 1))) {
                result -= decodingRomanSingleChar(IntegerToRomanNumeral.charAt(i));
            } else {
                result += decodingRomanSingleChar(IntegerToRomanNumeral.charAt(i));
            }
        }
        result += decodingRomanSingleChar(IntegerToRomanNumeral.charAt(IntegerToRomanNumeral.length() - 1));
        if (result < 0 || result > 10) throw new Exception("Число должно быть от 1 до 10");
        return result;
    }
}