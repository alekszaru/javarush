package com.javarush.test.level18.lesson10.home01;

/* Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв)
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        int count=0;
        FileInputStream f = new FileInputStream(args[0]);
        String alp = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";
        char[] alph = alp.toCharArray();
        while(f.available()>0)
        {
            int data = f.read();
            for (int i = 0; i < alph.length; i++)
            {
                if (data ==alph[i])
                {
                    count++;
                }
            }
        }
        System.out.println(count);
        f.close();
    }
}
