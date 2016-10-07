package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать через пробел во второй файл
Закрыть потоки. Не использовать try-with-resources
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
-3.49 - -3
-3.50 - -3
-3.51 - -4
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String name1 = r.readLine();
        String name2 = r.readLine();
        BufferedReader fileReader = new BufferedReader(new FileReader(name1));
        RandomAccessFile fileWriter = new RandomAccessFile(name2,"rw");
        String s="";
            while (true){
            s = fileReader.readLine();
            if (s==null)break;
            String[] text = s.split(" ");
            for(String temp: text){
               int i = (int) Math.round(Double.parseDouble(temp));
                fileWriter.writeBytes(String.valueOf(i) + " ");
            }
        }

        r.close();
        fileReader.close();
        fileWriter.close();
    }
}
