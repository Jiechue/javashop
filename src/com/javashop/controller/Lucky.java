package com.javashop.controller;

import com.javashop.pojo.Gift;
import com.javashop.service.GiftService;
import com.javashop.service.UserGiftService;
import com.javashop.service.impl.GiftServiceImpl;
import com.javashop.service.impl.UserGiftServiceImpl;
import com.javashop.util.CheckInputData;
import com.javashop.util.CheckLogin;
import com.javashop.util.UserLogin;

import java.util.List;
import java.util.Random;

public class Lucky implements Operate {
    private GiftService giftService = new GiftServiceImpl();
    private UserGiftService userGiftService = new UserGiftServiceImpl();

    @Override
    public void start() throws Exception {
        menu.showRandomMenu();
        String data = CheckInputData.checkData("1", "2");
        switch (data) {
            case "1":
                luckDraw();
                break;
            case "2":
                menu.start();
        }
    }

    public void luckDraw() throws Exception {
        CheckLogin.check();
        Integer number = luckDrawPart();

        if (number == null){
            start();
            return;
        }

        System.out.println("恭喜，您获得以下礼物：");
        //获得抽到的礼物
        Gift gift = giftService.showGift(number);
        System.out.println("名称：" + gift.getGiftName() + ",价值：" + gift.getPrice() + "元,可在'我的礼物'中查看");
        //添加进我的礼物
        userGiftService.addGiftInUser(UserLogin.user.getId(), gift.getId());

        back("#","0");
    }
    public Integer luckDrawPart() throws Exception {
        List<Gift> list = giftService.showAllGift();
        String[] giftIdCheck = new String[list.size()];
        for (int i=0;i<list.size();i++){
            giftIdCheck[i]= String.valueOf(list.get(i).getId());
        }
        for (int i = 1; i <= 3; i++) {
            Random r = new Random();
            int number = r.nextInt(giftIdCheck.length) + 1;
            System.out.println("请在0-"+giftIdCheck.length+"之间任意选择一个数,作为你的幸运数字。");
            int choice = Integer.parseInt(CheckInputData.checkData(giftIdCheck));
            if (choice == number) {
                return number;
            } else if (i==3) {
                System.out.println("很遗憾，你未能获得礼物，本次幸运数是：" + number + ",你还有0次机会");
                break;
            }
            System.out.println("很遗憾，你未能获得礼物，本次幸运数是：" + number + ",你还有" + (3 - i) + "次机会");
            System.out.println("继续请按1，返回请按#");
            String input = CheckInputData.checkData("1", "#");

            if ("#".equals(input)) {
                start();
                break;
            }
        }

        return null;
    }
}
