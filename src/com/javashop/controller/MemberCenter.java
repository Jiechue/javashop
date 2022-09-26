package com.javashop.controller;

import com.javashop.pojo.Order;
import com.javashop.pojo.OrderDetail;
import com.javashop.pojo.Users;
import com.javashop.pojo.UsersGift;
import com.javashop.service.OrderService;
import com.javashop.service.UserGiftService;
import com.javashop.service.UserService;
import com.javashop.service.impl.OrderServiceImpl;
import com.javashop.service.impl.UserGiftServiceImpl;
import com.javashop.service.impl.UserServiceImpl;
import com.javashop.util.CheckInputData;
import com.javashop.util.CheckLogin;
import com.javashop.util.UserLogin;

import java.util.List;

public class MemberCenter implements Operate {
    private UserService userService = new UserServiceImpl();
    private OrderService orderService = new OrderServiceImpl();
    private UserGiftService userGiftService = new UserGiftServiceImpl();

    @Override
    public void start() throws Exception {
        menu.showMemberMenu();
        String data = CheckInputData.checkData("1", "2", "3", "4");
        switch (data) {
            case "1":
                //修改资料
                update();
                break;
            case "2":
                //查看订单
                order();
                break;
            case "3":
                //查看礼物
                gift();
                break;
            case "4":
                //返回上层
                menu.start();
        }
    }

    public void update() throws Exception {
        CheckLogin.check();
        //修改密码功能
        Users user = menu.update();
        user.setLoginId(UserLogin.user.getLoginId());
        userService.update(user);
        back("#","0");
    }
    public void order() throws Exception {
        CheckLogin.check();
        //显示用户订单信息（用户编号）
        List<Order> list = orderService.showOrderListByUid(UserLogin.user.getId());
        System.out.println("订单个数为：" + list.size());
        for (Order order : list) {
            System.out.println("*********************************************************************");
            System.out.println("订单编号：" + order.getId() + "\t" + order.getTotal() + "\t" + order.getAddDate());
            System.out.println("订单明细：");
            System.out.println("商品名称\t\t商品数量\t\t商品单价\t\t小计");
            for (OrderDetail detail : order.getOrderList()) {
                System.out.println(detail.getGoods().getGoodsName() + "\t\t" + detail.getNumber() + "\t\t" + detail.getGoods().getPrice() + "\t\t" + detail.getNumber() * detail.getGoods().getPrice());
            }
        }
        back("#","0");
    }

    public void gift() throws Exception {
        CheckLogin.check();
        List<UsersGift> list = userGiftService.showAllUsersGiftByUid(UserLogin.user.getId());
        System.out.println("您获得的礼物如下：\n" +
                "礼物数量：" + list.size());
        System.out.println("-------------------------------------------------------------------------\n" +
                "礼物名称\t\t礼物价值");
        for (UsersGift u : list) {
            System.out.println(u.getGift().getGiftName() + "\t\t ￥" + u.getGift().getPrice());
        }
        System.out.println("-------------------------------------------------------------------------\n");
        back("#","0");
    }
}
