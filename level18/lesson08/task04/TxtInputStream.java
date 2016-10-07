package com.javarush.test.level18.lesson08.task04;

import java.io.*;
import java.nio.channels.FileChannel;

/* UnsupportedFileName
Измените класс TxtInputStream так, чтобы он работал только с txt-файлами (*.txt)
Например, first.txt или name.1.part3.txt
Если передан не txt-файл, например, file.txt.exe, то конструктор должен выбрасывать исключение UnsupportedFileNameException
*/

public class TxtInputStream extends FileInputStream {

    private FileInputStream fis;

    public TxtInputStream(String fileName) throws FileNotFoundException, UnsupportedFileNameException
    {
        super(fileName);
            if(!fileName.contains(".txt")){
            throw new UnsupportedFileNameException();}


    }


}

