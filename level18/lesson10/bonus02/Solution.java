package com.javarush.test.level18.lesson10.bonus02;

/* Прайсы
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-c  - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id, найденный в файле

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
        bufferedReader.close();

        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));

        if (args[0].equals("-c")){
            int id = getMaxId(fileName)+1;
            String strId = getItem(String.valueOf(id),8);
            String price = getItem(args[args.length-2],8);
            String  quantity = getItem(args[args.length-1],4);
            String productName ="";
            for(int i= 1; i<args.length-2; i++){
                productName =productName + args[i];
                productName = productName+ " ";
            }
            productName = getItem(productName,30);

            String rezult = id+productName+price+quantity+"\\n";

writer.write(rezult);


        }

writer.close();
    }

    public static int getMaxId(String name) throws IOException{
        BufferedReader reader = new BufferedReader(new FileReader(name));
        int max=0;
        String line = "";
        ArrayList<Integer> list = new ArrayList<Integer>();
        while ((line = reader.readLine())!=null){
            String item = line.substring(0,7);
            item = item.replace(" ","");
            list.add(Integer.parseInt(item));
        }

        for (Integer temp : list){
            if (temp>max){
                max = temp;
            }
        }

        return max;
    }

    public static String getItem(String line, int numOfChars){
        if(line.length()==numOfChars){
            return line;
        }

        else if(line.length()>numOfChars)
        {
            line = line.substring(0, numOfChars - 1);
            return line;
        }

        else {
            for(int i = line.length()-1;i<numOfChars-1;i++){
                line = line+" ";
            }
            return line;
        }




    }
}
