package com.javashop.pojo;

import java.util.Date;
import java.util.List;

public class Order {
    private Integer id;
    private Users users;
    private Double total;
    private Date addDate;
    private String isPay;

    private List<OrderDetail> orderList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Date getAddDate() {
        return addDate;
    }

    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }

    public String getIsPay() {
        return isPay;
    }

    public void setIsPay(String isPay) {
        this.isPay = isPay;
    }

    public List<OrderDetail> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<OrderDetail> orderList) {
        this.orderList = orderList;
    }


}
