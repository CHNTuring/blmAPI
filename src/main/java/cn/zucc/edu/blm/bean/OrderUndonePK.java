package cn.zucc.edu.blm.bean;

import java.io.Serializable;

public class OrderUndonePK implements Serializable {

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Integer getListId() {
        return listId;
    }

    public void setListId(Integer listId) {
        this.listId = listId;
    }

    private int orderId;
    private Integer listId;
}
