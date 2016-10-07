package com.javarush.test.level18.lesson03.task05;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;




/* Сортировка байт
Ввести с консоли имя файла
Считать все байты из файла.
Не учитывая повторений - отсортировать их по байт-коду в возрастающем порядке.
Вывести на экран
Закрыть поток ввода-вывода

Пример байт входного файла
44 83 44

Пример вывода
44 83
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String name = r.readLine();
        FileInputStream fis = new FileInputStream(name);
        ArrayList<Integer> list = new ArrayList<Integer>();
        while (fis.available()>0){
            int temp = fis.read();
            list.add(temp);
        }
        Collections.sort(list);
        for(int i=0; i<list.size();i++)
        {
            for (int j = i + 1; j < list.size(); j++)
            {
                if (list.get(i).equals(list.get(j)))
                {
                    list.remove(j--);

                }
            }
        }

        for(Integer print : list){
            System.out.print(print+" ");
        }


        r.close();
        fis.close();

    }
}
