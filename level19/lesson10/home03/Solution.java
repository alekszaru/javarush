package com.javarush.test.level19.lesson10.home03;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/* Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами

Заполнить список PEOPLE импользуя данные из файла
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException
    {
        String fileName = args[0];
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line = "";

        while ((line = reader.readLine())!=null){
            String[] li = line.split(" ");
            int year = Integer.parseInt(li[li.length-1]);
            int month = Integer.parseInt(li[li.length-2])-1;
            int day = Integer.parseInt(li[li.length-3]);
            String name = "";
            Date date;
            for(int i = 0; i<li.length-3; i++){
                 name = name+li[i]+" ";
            }
            name = name.substring(0,name.length()-1);
            Calendar calendar = new GregorianCalendar();
            calendar.set(year,month,day);
            date = calendar.getTime();
            PEOPLE.add(new Person(name,date));
        }

        reader.close();
    }

}
