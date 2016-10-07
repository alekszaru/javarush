package com.javarush.test.level18.lesson10.bonus02;

/**
 * Created by Дмитрий on 09.09.16.
 */
public class test
{
    public static void main(String args[]) throws Exception
    {
        String productName = "";
        for (int i = 1; i < args.length - 2; i++)
        {
            if (i != args.length - 2)
            {
                productName += args[i] + " ";
            } else productName += args[i];
        }
        if (productName.length() > 30)
        {
           productName=productName.substring(0, 30);
        }
        else
        {
            for (int i = productName.length(); i < 30; i++)
            {
                productName += " ";
            }
        }
        System.out.println(productName);
    }
}
