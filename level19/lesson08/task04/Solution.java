package com.javarush.test.level19.lesson08.task04;

/* Решаем пример
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна выводить на консоль решенный пример
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Возможные операции: + - *
Шаблон входных данных и вывода: a [знак] b = c
Отрицательных и дробных чисел, унарных операторов - нет.

Пример вывода:
3 + 6 = 9
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream console = System.out;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        testString.printSomething();
        String rezult = outputStream.toString();

        System.setOut(console);

        String[] list = rezult.split(" ");
        int a = Integer.parseInt(list[0]);
        String znak = list[1];
        int b = Integer.parseInt(list[2]);
        int c =0;
        if(znak.equals("+")){
            c = a+b;
        }
        else if(znak.equals("-")){
            c = a-b;
        }
        else if(znak.equals("*")){
            c = a*b;
        }
        String finalRezult = a+" "+znak+" "+b+" = "+c;
        System.out.print(finalRezult);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

