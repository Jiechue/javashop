package com.javashop.controller;

import com.javashop.pojo.Goods;
import com.javashop.pojo.Order;
import com.javashop.pojo.OrderDetail;
import com.javashop.service.GoodsService;
import com.javashop.service.OrderService;
import com.javashop.service.impl.GoodsServiceImpl;
import com.javashop.service.impl.OrderServiceImpl;
import com.javashop.util.*;

import java.util.*;

public class Shopping implements Operate {
    private GoodsService goodsService = new GoodsServiceImpl();
    private OrderService orderService = new OrderServiceImpl();
    @Override
    public void start() throws Exception {
        menu.showShopMenu();
        String data = CheckInputData.checkData("1", "2");
        switch (data) {
            case "1":
                shopping();
                break;
            case "2":
                menu.start();
        }
    }

    public void shopping() throws Exception {
        CheckLogin.check();

        List<Goods> goods = goodsService.showAllGoods();
        System.out.println("商品列表如下，请输入你要购买的商品编号\n" +
                "商品编号\t商品名称\t\t价格");
        for (int i = 0; i < goods.size(); i++) {
            System.out.println(goods.get(i).getId() + "\t" + goods.get(i).getGoodsName() + "\t ￥" + goods.get(i).getPrice());
        }
        //创建OrderDetail集合对象(创建购物车)
        List<OrderDetail> list = new ArrayList<>();

        //根据商品情况动态设置输入购买商品id时的限制
        String[] giftIdCheck=new String[goods.size()];
        for (int i=0;i<goods.size();i++){
            giftIdCheck[i]= String.valueOf(goods.get(i).getId());
        }

        //创建订单对象
        Order order = new Order();
        order.setUsers(UserLogin.user);
        order.setIsPay("0");

        //循环购买商品过程
        do {
            String choice = CheckInputData.checkData(giftIdCheck);
            //查询购买的商品
            Goods good = goodsService.showGoodById(Integer.parseInt(choice));
            //创建detail对象
            OrderDetail orderDetail = new OrderDetail();
            //把要购买的商品封装进detail
            orderDetail.setGoods(good);
            //购买数量
            System.out.print("请输入数量：");
            //验证数量是否为数字
            Double number = CheckNum.checkNum();
            //封装数量
            orderDetail.setNumber(number);
            //把已封装的订单详情对象加入到集合中（添加购物车）
            list.add(orderDetail);
            System.out.println("商品已添加到购物车，继续选购请按1，结算请按2，返回请按#。");
            String choice2 = CheckInputData.checkData("1", "2", "#");
            //如果选择返回则
            if ("#".equals(choice2)) {
                //清除购物车
                list.clear();
                start();
                break;
            }
            //如果选择结算则
            else if ("2".equals(choice2)) {
                break;
            }
            //选择继续购买则continue，继续while循环
            System.out.println("选择了继续购物，请挑选商品，输入要购买的商品编号");
        } while (true);

        //选择结算后跳出循环进入结算
        System.out.println("您的购物车中有" + list.size() + "个商品。确定购买吗？按 y 付款，按 # 退出购买");
        String choice = CheckInputData.checkData("y", "#");
        switch (choice) {
            //确认已付款
            case "y":
                //把订单详细类的集合封装进order
                order.setOrderList(list);
                order.setTotal(CountOrderTotal.CountTotal(list));
                order.setIsPay("1");
                order.setAddDate(new Date());
                //判断是否购买成功
                boolean b = orderService.buy(order);
                if (b) {
                    System.out.println("购买成功，有" + list.size() + "条商品被购买");
                    list.clear();
                    back("#","0");
                }else {
                    System.out.println("购买失败");
                }
                break;
            //如果选择退出购买则
            case "#":
                list.clear();
                start();
        }
    }
}
