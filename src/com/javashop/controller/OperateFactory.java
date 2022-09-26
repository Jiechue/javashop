package com.javashop.controller;

public class OperateFactory {
    public static Operate createOperate(String type) throws Exception {
        if ("1".equals(type)) {
            return new MemberCenter();
        } else if ("2".equals(type)) {
            return new Shopping();
        } else if ("3".equals(type)) {
            return new Lucky();
        } else {
            throw new Exception("输入错误");
        }
    }
}
