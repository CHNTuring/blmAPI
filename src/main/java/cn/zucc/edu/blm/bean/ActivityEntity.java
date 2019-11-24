package cn.zucc.edu.blm.bean;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "activity", schema = "blm")
public class ActivityEntity {
    private Integer activityId;
    private Integer shopId;
    private Double fullMoney;
    private Double reduceMoney;


    @Id
    @Column(name = "activity_id")
    public int getActivityId() {
        return activityId;
    }

    public void setActivityId(int activityId) {
        this.activityId = activityId;
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
    @Column(name = "full_money")
    public Double getFullMoney() {
        return fullMoney;
    }

    public void setFullMoney(Double fullMoney) {
        this.fullMoney = fullMoney;
    }

    @Basic
    @Column(name = "reduce_money")
    public Double getReduceMoney() {
        return reduceMoney;
    }

    public void setReduceMoney(Double reduceMoney) {
        this.reduceMoney = reduceMoney;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActivityEntity that = (ActivityEntity) o;
        return activityId == that.activityId &&
                Objects.equals(shopId, that.shopId) &&
                Objects.equals(fullMoney, that.fullMoney) &&
                Objects.equals(reduceMoney, that.reduceMoney);
    }

    @Override
    public int hashCode() {
        return Objects.hash(activityId, shopId, fullMoney, reduceMoney);
    }


}
