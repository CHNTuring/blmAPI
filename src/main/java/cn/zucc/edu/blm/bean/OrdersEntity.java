package cn.zucc.edu.blm.bean;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "orders", schema = "blm" )
public class OrdersEntity {
    private Integer orderId;
    private Integer shopId;
    private Integer userId;
    private Integer temporaryId;
    private Timestamp orderStartTime;
    private Timestamp orderFinishTime;
    private String orderStatus;
    private String orderRemark;


    @Id
    @Column(name = "order_id")
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "shop_id")
    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    @Basic
    @Column(name = "user_id")
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "temporary_id")
    public Integer getTemporaryId() {
        return temporaryId;
    }

    public void setTemporaryId(Integer temporaryId) {
        this.temporaryId = temporaryId;
    }

    @Basic
    @Column(name = "order_start_time")
    public Timestamp getOrderStartTime() {
        return orderStartTime;
    }

    public void setOrderStartTime(Timestamp orderStartTime) {
        this.orderStartTime = orderStartTime;
    }

    @Basic
    @Column(name = "order_finish_time")
    public Timestamp getOrderFinishTime() {
        return orderFinishTime;
    }

    public void setOrderFinishTime(Timestamp orderFinishTime) {
        this.orderFinishTime = orderFinishTime;
    }

    @Basic
    @Column(name = "order_status")
    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Basic
    @Column(name = "order_remark")
    public String getOrderRemark() {
        return orderRemark;
    }

    public void setOrderRemark(String orderRemark) {
        this.orderRemark = orderRemark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrdersEntity that = (OrdersEntity) o;
        return orderId == that.orderId &&
                Objects.equals(shopId, that.shopId) &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(temporaryId, that.temporaryId) &&
                Objects.equals(orderStartTime, that.orderStartTime) &&
                Objects.equals(orderFinishTime, that.orderFinishTime) &&
                Objects.equals(orderStatus, that.orderStatus) &&
                Objects.equals(orderRemark, that.orderRemark);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, shopId, userId, temporaryId, orderStartTime, orderFinishTime, orderStatus, orderRemark);
    }

}
