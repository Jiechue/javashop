package com.javashop.view;

import com.javashop.controller.Operate;
import com.javashop.controller.OperateFactory;
import com.javashop.pojo.Users;
import com.javashop.util.CheckInputData;

import java.util.Scanner;

public class Menu {
    public void showMainMenu() {
        System.out.println("*********请选择您要的操作***************");
        System.out.println("*\t\t1、会 员 中 心                     *");
        System.out.println("*\t\t2、进 入 购 物                     *");
        System.out.println("*\t\t3、试 试 手 气                     *");
        System.out.println("******************************************");
    }

    /**
     * 显示会员中心子菜单
     */
    public void showMemberMenu() {
        System.out.println("*********请选择您要的操作***************");
        System.out.println("*\t\t1、修 改 资 料                     *");
        System.out.println("*\t\t2、我 的 订 单                     *");
        System.out.println("*\t\t3、我 的 礼 物                     *");
        System.out.println("*\t\t4、返 回 上 层                     *");
        System.out.println("******************************************");
    }

    /**
     * 显示试试手气菜单
     */
    public void showRandomMenu() {
        System.out.println("*********请选择您要的操作***************");
        System.out.println("*\t\t1、开始手气之旅                 *");
        System.out.println("*\t\t2、返 回 上 层                     *");
        System.out.println("******************************************");
    }

    /**
     * 显示开始购物菜单
     */
    public void showShopMenu() {
        System.out.println("*********请选择您要的操作***************");
        System.out.println("*\t\t1、选 择 商 品                     *");
        System.out.println("*\t\t2、返 回 上 层                     *");
        System.out.println("******************************************");
    }

    public void start() {
        showMainMenu();
        String num = CheckInputData.checkData("1", "2", "3");
        try {
            Operate operate = OperateFactory.createOperate(num);
            operate.start();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            System.out.println("系统错误，重新启动");
            start();
        }
    }

    public Users login() {
        Scanner input = new Scanner(System.in);
        Users user = new Users();
        System.out.println("************以下操作需要您先登录，请输入用户名：**************");
        user.setLoginId(input.next());
        System.out.println("请输入登录密码：");
        user.setLoginPwd(input.next());
        return user;
    }
    public Users update(){
        Users user = new Users();
        Scanner input = new Scanner(System.in);
        System.out.println("提供密码修改功能，请输入新密码:");
        String pwd = input.next();
        do {
            System.out.println("请再一次输入新密码确认");
            String apwd = input.next();
            if (pwd.equals(apwd)) {
                user.setLoginPwd(pwd);
                return user;
            }else {
                System.out.println("两次输入的密码不符，请重新输入");
            }
        }while (true);
    }
}

