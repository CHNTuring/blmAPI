package cn.zucc.edu.blm.bean;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "order_sum", schema = "blm")
public class OrderSum {
    private int orderId;
    private Double sumRecipeRecipePriceOrderInfOrderRecipeNumber;

    @Id
    @Column(name = "order_id")
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "Sum(recipe.recipe_price*order_inf.order_recipe_number)")
    public Double getSumRecipeRecipePriceOrderInfOrderRecipeNumber() {
        return sumRecipeRecipePriceOrderInfOrderRecipeNumber;
    }

    public void setSumRecipeRecipePriceOrderInfOrderRecipeNumber(Double sumRecipeRecipePriceOrderInfOrderRecipeNumber) {
        this.sumRecipeRecipePriceOrderInfOrderRecipeNumber = sumRecipeRecipePriceOrderInfOrderRecipeNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderSum orderSum = (OrderSum) o;
        return orderId == orderSum.orderId &&
                Objects.equals(sumRecipeRecipePriceOrderInfOrderRecipeNumber, orderSum.sumRecipeRecipePriceOrderInfOrderRecipeNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, sumRecipeRecipePriceOrderInfOrderRecipeNumber);
    }
}
