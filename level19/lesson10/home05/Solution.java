package com.javarush.test.level19.lesson10.home05;

/* Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит строки со слов, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        reader.close();
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName1));

        String line = "";
        ArrayList<String> list = new ArrayList<String>();
        while ((line = fileReader.readLine())!=null){
            String[] wordsINLine = line.split(" ");
            for(String word:wordsINLine){


                    if (word.matches(".*\\d.*"))
                    {
                        list.add(word);

                    }


            }
        }
        fileReader.close();

        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName2));


        String text = "";
        for(String w:list){
          text = text + w +" ";
        }
        text = text.substring(0,text.length()-1);
        writer.write(text);
        writer.close();
    }
}
