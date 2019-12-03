package cn.zucc.edu.blm.bean;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Objects;

@Entity
@Table(name = "order_undone", schema = "blm")
public class OrderUndone {
    @Id

    private int orderId;
    private Timestamp orderStartTime;
    private Integer temporaryId;
    private Integer listId;
    private String recipeName;
    private Integer orderRecipeNumber;
    private String userName;
    private byte[] recipeImage;
    private String orderRemark;
    private Timestamp orderFinishTime;
    private String orderStatus;
    private Integer shopId;

    @Basic
    @Column(name = "order_id")
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
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
    @Column(name = "temporary_id")
    public Integer getTemporaryId() {
        return temporaryId;
    }

    public void setTemporaryId(Integer temporaryId) {
        this.temporaryId = temporaryId;
    }

    @Basic
    @Column(name = "list_id")
    public Integer getListId() {
        return listId;
    }

    public void setListId(Integer listId) {
        this.listId = listId;
    }

    @Basic
    @Column(name = "recipe_name")
    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    @Basic
    @Column(name = "order_recipe_number")
    public Integer getOrderRecipeNumber() {
        return orderRecipeNumber;
    }

    public void setOrderRecipeNumber(Integer orderRecipeNumber) {
        this.orderRecipeNumber = orderRecipeNumber;
    }

    @Basic
    @Column(name = "user_name")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "recipe_image")
    public byte[] getRecipeImage() {
        return recipeImage;
    }

    public void setRecipeImage(byte[] recipeImage) {
        this.recipeImage = recipeImage;
    }

    @Basic
    @Column(name = "order_remark")
    public String getOrderRemark() {
        return orderRemark;
    }

    public void setOrderRemark(String orderRemark) {
        this.orderRemark = orderRemark;
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
    @Column(name = "shop_id")
    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderUndone that = (OrderUndone) o;
        return orderId == that.orderId &&
                Objects.equals(orderStartTime, that.orderStartTime) &&
                Objects.equals(temporaryId, that.temporaryId) &&
                Objects.equals(listId, that.listId) &&
                Objects.equals(recipeName, that.recipeName) &&
                Objects.equals(orderRecipeNumber, that.orderRecipeNumber) &&
                Objects.equals(userName, that.userName) &&
                Arrays.equals(recipeImage, that.recipeImage) &&
                Objects.equals(orderRemark, that.orderRemark) &&
                Objects.equals(orderFinishTime, that.orderFinishTime) &&
                Objects.equals(orderStatus, that.orderStatus) &&
                Objects.equals(shopId, that.shopId);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(orderId, orderStartTime, temporaryId, listId, recipeName, orderRecipeNumber, userName, orderRemark, orderFinishTime, orderStatus, shopId);
        result = 31 * result + Arrays.hashCode(recipeImage);
        return result;
    }
}
