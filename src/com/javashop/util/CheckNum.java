package com.javashop.util;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckNum {
    public static double checkNum(){
        Scanner input = new Scanner(System.in);
        String num = null;
        do {
            num = input.next();
            Pattern pattern = Pattern.compile("[0-9]+[.]{0,1}[0-9]*[dD]{0,1}");
            Matcher isNum = pattern.matcher(num);
            if (isNum.matches()) {
                break;
            }
            System.out.println("您输入的不是数字，请重新输入");
        }while (true);
        return Double.parseDouble(num);
    }
}
