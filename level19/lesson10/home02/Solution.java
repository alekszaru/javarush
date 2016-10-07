package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
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
        Double max = 0.0;
        for (SortedMap.Entry entry:map.entrySet()){
           Double temp = (Double) entry.getValue();
            if(temp>max){max=temp;}
        }

        for (SortedMap.Entry entry:map.entrySet()){
            Double temp = (Double) entry.getValue();
            if(temp==max){
                System.out.println(entry.getKey());
            }
        }

    }
}
