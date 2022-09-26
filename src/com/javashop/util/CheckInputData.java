package com.javashop.util;

import java.util.Scanner;

public class CheckInputData {

    public static String checkData(String...nums) {
        Scanner input=new Scanner(System.in);
        String data=null;
        do {
            boolean isOk=false;
            System.out.print("请输入:");
            data=input.next();
            for(String num:nums) {
                if(data.equals(num)) {
                    isOk=true;
                    return data;
                }
            }
            if(!isOk) {
                System.out.print("输入错误，请重新输入:");
            }

        }while(true);


    }

}
