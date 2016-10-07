package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String name1 = r.readLine();
        String name2 = r.readLine();

        FileInputStream fis2 = new FileInputStream(name2);
        FileInputStream fis1 = new FileInputStream(name1);


        byte[] buffer = new byte[fis1.available()];
        fis1.read(buffer);
        FileOutputStream fos1 = new FileOutputStream(name1, false);

        while (fis2.available()>0){
            int data = fis2.read();
            fos1.write(data);
        }
        fos1 = new FileOutputStream(name1,true);
        fos1.write(buffer);


        r.close();
        fis2.close();
        fis1.close();
        fos1.close();

    }
    }

