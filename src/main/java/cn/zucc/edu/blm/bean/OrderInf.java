package cn.zucc.edu.blm.bean;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "order_inf", schema = "blm")
public class OrderInf {
    private int orderInfId;
    private Integer recipeId;
    private Integer orderId;
    private Integer listId;
    private Integer orderRecipeNumber;

    @Id
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderInf orderInf = (OrderInf) o;
        return orderInfId == orderInf.orderInfId &&
                Objects.equals(recipeId, orderInf.recipeId) &&
                Objects.equals(orderId, orderInf.orderId) &&
                Objects.equals(listId, orderInf.listId) &&
                Objects.equals(orderRecipeNumber, orderInf.orderRecipeNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderInfId, recipeId, orderId, listId, orderRecipeNumber);
    }
}
