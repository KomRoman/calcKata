import javax.xml.transform.SourceLocator;
import java.util.*;
import java.lang.String;
import java.io.*;

/*
 Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
 then press Enter. You can now see whitespace characters in your code.
*/

public class Main {
    public static boolean isNumeric(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) {

        String[] znak  = new String[4];
        znak [0] = "+";
        znak [1] = "-";
        znak [2] = "*";
        znak [3] = "/";
        int count = 0;
        int kolZn = 0;
        boolean w = true;
        String znakZ = "";
        int compareOneTwo = 1;
        int operator1;
        int operator2;
        int oper1 = 0;
        int oper2 = 0;
        double rez =0;
        String rez1 = "";
        int rez2 = 1;

        var myList = List.of("I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C");


        String inCalc;
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Введите выражение по условию задачи:");
            inCalc = scanner.nextLine();
        }

        //удаляем пробелы в введеном выражении
        inCalc = inCalc.replaceAll("\\s+", "");
        // первод в верхний регистр
        inCalc = inCalc.toUpperCase();
        // зменяем . на ,
        inCalc = inCalc.replace('.', ',');

        // проверяем есть ли знаки +-*/ и какое их кол-во


        for(int i = 0; i < 4; i++) {
             String ch = znak [i];
             count = inCalc.length() - inCalc.replace(String.valueOf(ch), "").length();
             kolZn = kolZn + count;
             if (count >0) {
                 znakZ = znak[i];
             }
         }


        if (kolZn !=1) {
            System.out.println ("Ошибка. Должен быть один арифметический знак:  + - * /");
            System.exit(0);
        }

        // Делим введенное выражение на 2 части.
        String[] operator = inCalc.split("\\" + znakZ);

        // проверка на условие что в выражении должно быть два оператора
        try {
            if (operator[0] == "" || operator[1] == "") {
                System.out.println("Ошибка. Должно быть два оператора");
                System.exit(0);
            }
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Ошибка. Должно быть два оператора");
            System.exit(0);}

        //System.out.println("Оператор 1: " + operator[0]);
        //System.out.println("Оператор 2: " + operator[1]);

        // только целые числа
        try {
            if ( isNumeric(operator[0]) == isNumeric(operator[1]) && isNumeric(operator[0]) == true && isNumeric(operator[1]) == true)
                {
                 int num1 = Integer.parseInt(operator[0]);
                 int num2 = Integer.parseInt(operator[1]);}
        } catch (NumberFormatException e) {
            System.out.println("Ошибка. Операторы должны быть целыми числами");
            System.exit(0);
        }

        // или арабские или римские

        if ( isNumeric(operator[0]) != isNumeric(operator[1]) )
        {
            System.out.println("Ошибка. Операторы должны быть в одной системе счисления");
            System.exit(0);
        }

        // перевод чисел из римских в арабские

        if ( isNumeric(operator[0]) == false) {

            try {
            oper1 = rimTOarab.valueOf(operator[0]).getI();
            oper2 = rimTOarab.valueOf(operator[1]).getI();
            }
            catch (IllegalArgumentException e) {
                System.out.println("Ошибка. Одно (или все) римское число не распознано");
                System.exit(0);
            }
        }

        else {
                // если арабские то оставляем как есть
                oper1 = Integer.parseInt(operator[0]);
                oper2 = Integer.parseInt(operator[1]);
        }

        // числа от 1 до 10
        if (oper1 < 1 | oper1 >10 | oper2 < 1 | oper2 >10) {
            System.out.println("Ошибка. Операторы должны быть от 1 до 10");
            System.exit(0);
        }

       switch (znakZ) {
            case "+":
                rez = oper1 + oper2;
                break;
           case "-":
               rez = oper1 - oper2;
               break;
           case "*":
               rez = oper1 * oper2;
               break;
           case "/":
               rez = oper1 / oper2;
               break;
        }

        if ( isNumeric(operator[0]) == false) {

            rez2 = (int) (rez-1);

            try {
                rez1 = myList.get(rez2);
            }
            catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Ошибка. Результат с римскими цифрами только > 0");
                System.exit(0);
            }
            System.out.println("Результат: " + rez1);

        } else
            System.out.println("Результат: " + rez);}


    }

