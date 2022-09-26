package com.javashop.util;

import com.javashop.pojo.Users;
import com.javashop.service.UserService;
import com.javashop.service.impl.UserServiceImpl;
import com.javashop.view.Menu;

public class CheckLogin {

    public static void check() throws Exception {
        if (UserLogin.user==null){
            Menu menu = new Menu();
            Users user = menu.login();
            UserService userService = new UserServiceImpl();
            Users login = userService.login(user.getLoginId(),user.getLoginPwd());
            if (login==null){
                System.out.println("用户名或密码不正确。请选择下一步操作：继续请按1，返回上一层请按#");
                String choice = CheckInputData.checkData("1","#");
                switch (choice){
                    case "1" :
                        check();
                        break;
                    case "0" :
                        menu.start();
                        break;
                }
            }
            System.out.println("***************登录成功，接下来进入登录之前的操作******************");
            //把登录用户信息保存到公共的类中
            UserLogin.user=login;
        }
    }
}
