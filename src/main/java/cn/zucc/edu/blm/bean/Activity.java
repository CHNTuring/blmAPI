package cn.zucc.edu.blm.bean;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Activity {
    private int activityId;
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
        Activity activity = (Activity) o;
        return activityId == activity.activityId &&
                Objects.equals(shopId, activity.shopId) &&
                Objects.equals(fullMoney, activity.fullMoney) &&
                Objects.equals(reduceMoney, activity.reduceMoney);
    }

    @Override
    public int hashCode() {
        return Objects.hash(activityId, shopId, fullMoney, reduceMoney);
    }
}
