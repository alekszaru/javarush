package com.javarush.test.level18.lesson10.home10;

/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        ArrayList<String> list = new ArrayList<String>(); //будем сохранять имена файлов для последующей сортировки

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream filereader;

        String name = null;
        while (!(name = reader.readLine()).equals("end")) //читаем имена файлов пока не введено енд
        {

            list.add(name); //добавляем имена в список
        }
        Collections.sort(list); // сортируем список

// найдём имя для нового файла
        String newFile = "";
        int dot = list.get(0).lastIndexOf('.');
        newFile = list.get(0).substring(0, dot);

        File file = new File(newFile);

        if (!file.exists())
        {
            file.createNewFile();
        }

        FileOutputStream out = new FileOutputStream(file);


        for (String fileName : list)
        {
            filereader = new FileInputStream(fileName);
            byte[] buffer = new byte[1000];
            while (filereader.available() > 0)
            {
                int count = filereader.read(buffer);
                out.write(buffer,0,count);
            }
            filereader.close();
        }

        reader.close();
        out.close();



    }
}
