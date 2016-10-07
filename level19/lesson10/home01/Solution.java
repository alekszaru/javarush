package com.javarush.test.level19.lesson10.home01;

/* Считаем зарплаты
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Все данные вывести в консоль, предварительно отсортировав в возрастающем порядке по имени
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 2
Сидоров 6
�?ванов 1.35
Петров 3.1

Пример вывода:
�?ванов 1.35
Петров 5.1
Сидоров 6.0
*/

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        String fileName = args[0];
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        Map<String,Double> map = new TreeMap<String, Double>();
        String line = "";
        while ((line = reader.readLine())!=null){
            String[] li = line.split(" ");
            String key = li[0];
            String val = li[1];

            Double value = Double.parseDouble(val);

            if(!map.containsKey(key)){
                map.put(key,value);
            }
            else{
                Double oldValue = map.get(key);
                Double newValue = oldValue + value;
                map.remove(key);
                map.put(key, newValue);
            }
        }

        reader.close();
        for(SortedMap.Entry entry:map.entrySet())
        {
            System.out.println(entry.getKey().toString() + " " +entry.getValue().toString());
        }

    }
}
