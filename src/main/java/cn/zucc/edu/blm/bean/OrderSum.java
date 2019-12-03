package cn.zucc.edu.blm.bean;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Objects;

@Entity
@Table(name = "order_sum", schema = "blm", catalog = "")
public class OrderSum {
    @Id

    private int orderId;
    private Integer shopId;
    private String shopName;
    private byte[] shopTrademark;
    private Integer temporaryId;
    private Double ordersum;
    private Integer userId;
    private String orderStatus;
    private Timestamp orderStartTime;
    private Timestamp orderFinishTime;

    @Basic
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
    @Column(name = "shop_name")
    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    @Basic
    @Column(name = "shop_trademark")
    public byte[] getShopTrademark() {
        return shopTrademark;
    }

    public void setShopTrademark(byte[] shopTrademark) {
        this.shopTrademark = shopTrademark;
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
    @Column(name = "ordersum")
    public Double getOrdersum() {
        return ordersum;
    }

    public void setOrdersum(Double ordersum) {
        this.ordersum = ordersum;
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
    @Column(name = "order_status")
    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderSum orderSum = (OrderSum) o;
        return orderId == orderSum.orderId &&
                Objects.equals(shopId, orderSum.shopId) &&
                Objects.equals(shopName, orderSum.shopName) &&
                Arrays.equals(shopTrademark, orderSum.shopTrademark) &&
                Objects.equals(temporaryId, orderSum.temporaryId) &&
                Objects.equals(ordersum, orderSum.ordersum) &&
                Objects.equals(userId, orderSum.userId) &&
                Objects.equals(orderStatus, orderSum.orderStatus) &&
                Objects.equals(orderStartTime, orderSum.orderStartTime) &&
                Objects.equals(orderFinishTime, orderSum.orderFinishTime);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(orderId, shopId, shopName, temporaryId, ordersum, userId, orderStatus, orderStartTime, orderFinishTime);
        result = 31 * result + Arrays.hashCode(shopTrademark);
        return result;
    }
}
