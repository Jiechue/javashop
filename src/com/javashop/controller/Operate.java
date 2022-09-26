package com.javashop.controller;

import com.javashop.util.CheckInputData;
import com.javashop.view.Menu;
import com.sun.applet2.Applet2;

//公共接口
public interface Operate {
        Menu menu = new Menu();
        //子菜单的开始
        void start() throws Exception;
        //返回
        default void back(String last,String top) throws Exception{
                System.out.println("请选择下一步操作,按"+last+"返回上一层，按"+top+"返回顶层。请输入：");
                String choice = CheckInputData.checkData(last, top);
                if (last.equals(choice)){
                        start();
                } else if (top.equals(choice)) {
                        menu.start();
                }
        };
}
