package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать в первый файл содержимое третьего файла
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String name1 = r.readLine();
        String name2 = r.readLine();
        String name3 = r.readLine();
        FileInputStream fis2 = new FileInputStream(name2);
        FileInputStream fis3 = new FileInputStream(name3);
        FileOutputStream fos1 = new FileOutputStream(name1);


        while (fis2.available()>0){
            int data = fis2.read();
            fos1.write(data);
        }

        while (fis3.available()>0){
            int data = fis3.read();
            fos1.write(data);
        }
r.close();
        fis2.close();
        fos1.close();
        fis3.close();
    }
}
