package com.javarush.test.level18.lesson10.bonus01;

/* Шифровка
Придумать механизм шифровки/дешифровки

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName
где
fileName - имя файла, который необходимо зашифровать/расшифровать
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования
-e - ключ указывает, что необходимо зашифровать данные
-d - ключ указывает, что необходимо расшифровать данные
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
String fileName = args[1];
        String fileOutputName = args[2];

        if (args[0].equals("-e")){
            encripting(fileName,fileOutputName);
        }

        else if (args[0].equals("-d")){
            decripting(fileName,fileOutputName);
        }
    }

        public static void encripting(String file1, String file2) throws IOException{
            FileInputStream fileInputStream = new FileInputStream(file1);
            FileOutputStream fileOutputStream = new FileOutputStream(file2);

            while (fileInputStream.available()>0){

                    int data = fileInputStream.read() + 3;
                    fileOutputStream.write(data);
            }

            fileInputStream.close();
            fileOutputStream.close();
         }

        public static void decripting(String file1, String file2)throws IOException{
            FileInputStream fileInputStream = new FileInputStream(file1);
            FileOutputStream fileOutputStream = new FileOutputStream(file2);

            while (fileInputStream.available()>0){
               int data = fileInputStream.read()-3;
                fileOutputStream.write(data);
            }
           fileInputStream.close();
            fileOutputStream.close();
        }



}
