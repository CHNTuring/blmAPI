package cn.zucc.edu.blm.bean;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "order_information", schema = "blm", catalog = "")
public class OrderInformation {
    @Id
    private int orderInfId;
    private Integer recipeId;
    private Integer orderId;
    private Integer listId;
    private Integer orderRecipeNumber;
    private Double recipeDiscount;
    private String recipeStatus;
    private Double recipePrice;
    private String recipeName;

    @Basic
    @Column(name = "order_inf_id")
    public int getOrderInfId() {
        return orderInfId;
    }

    public void setOrderInfId(int orderInfId) {
        this.orderInfId = orderInfId;
    }

    @Basic
    @Column(name = "recipe_id")
    public Integer getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(Integer recipeId) {
        this.recipeId = recipeId;
    }

    @Basic
    @Column(name = "order_id")
    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
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
    @Column(name = "order_recipe_number")
    public Integer getOrderRecipeNumber() {
        return orderRecipeNumber;
    }

    public void setOrderRecipeNumber(Integer orderRecipeNumber) {
        this.orderRecipeNumber = orderRecipeNumber;
    }

    @Basic
    @Column(name = "recipe_discount")
    public Double getRecipeDiscount() {
        return recipeDiscount;
    }

    public void setRecipeDiscount(Double recipeDiscount) {
        this.recipeDiscount = recipeDiscount;
    }

    @Basic
    @Column(name = "recipe_status")
    public String getRecipeStatus() {
        return recipeStatus;
    }

    public void setRecipeStatus(String recipeStatus) {
        this.recipeStatus = recipeStatus;
    }

    @Basic
    @Column(name = "recipe_price")
    public Double getRecipePrice() {
        return recipePrice;
    }

    public void setRecipePrice(Double recipePrice) {
        this.recipePrice = recipePrice;
    }

    @Basic
    @Column(name = "recipe_name")
    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderInformation that = (OrderInformation) o;
        return orderInfId == that.orderInfId &&
                Objects.equals(recipeId, that.recipeId) &&
                Objects.equals(orderId, that.orderId) &&
                Objects.equals(listId, that.listId) &&
                Objects.equals(orderRecipeNumber, that.orderRecipeNumber) &&
                Objects.equals(recipeDiscount, that.recipeDiscount) &&
                Objects.equals(recipeStatus, that.recipeStatus) &&
                Objects.equals(recipePrice, that.recipePrice) &&
                Objects.equals(recipeName, that.recipeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderInfId, recipeId, orderId, listId, orderRecipeNumber, recipeDiscount, recipeStatus, recipePrice, recipeName);
    }
}
