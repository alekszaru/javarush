package com.javarush.test.level18.lesson03.task04;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* Самые редкие байты
Ввести с консоли имя файла
Найти байт или байты с минимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String name = r.readLine();
        FileInputStream fis = new FileInputStream(name);
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        while(fis.available()>0){
            int key = fis.read();
            if(map.containsKey(key)){
                int value = map.get(key);
                map.put(key,++value);
            }
            else map.put(key,1);}

        int temp = 1000;
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            if(temp>entry.getValue()){
                temp=entry.getValue();
            }
        }

        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            if (entry.getValue()==temp){
                System.out.println(entry.getKey());
            }
        }




        r.close();
        fis.close();

    }
}