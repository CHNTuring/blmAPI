package cn.zucc.edu.blm.bean;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "shop", schema = "blm")
public class ShopEntity {
    private Integer shopId;
    private String shopName;
    private String shopPwd;
    private String shopAddress;
    private String shopTel;
    private Double shopCore;
    private String shopNotice;
    private String shopTrademark;
    private String shopStatus;


    @Id
    @Column(name = "shop_id")
    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
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
    @Column(name = "shop_pwd")
    public String getShopPwd() {
        return shopPwd;
    }

    public void setShopPwd(String shopPwd) {
        this.shopPwd = shopPwd;
    }

    @Basic
    @Column(name = "shop_address")
    public String getShopAddress() {
        return shopAddress;
    }

    public void setShopAddress(String shopAddress) {
        this.shopAddress = shopAddress;
    }

    @Basic
    @Column(name = "shop_tel")
    public String getShopTel() {
        return shopTel;
    }

    public void setShopTel(String shopTel) {
        this.shopTel = shopTel;
    }

    @Basic
    @Column(name = "shop_core")
    public Double getShopCore() {
        return shopCore;
    }

    public void setShopCore(Double shopCore) {
        this.shopCore = shopCore;
    }

    @Basic
    @Column(name = "shop_notice")
    public String getShopNotice() {
        return shopNotice;
    }

    public void setShopNotice(String shopNotice) {
        this.shopNotice = shopNotice;
    }

    @Basic
    @Column(name = "shop_trademark")
    public String getShopTrademark() {
        return shopTrademark;
    }

    public void setShopTrademark(String shopTrademark) {
        this.shopTrademark = shopTrademark;
    }

    @Basic
    @Column(name = "shop_status")
    public String getShopStatus() {
        return shopStatus;
    }

    public void setShopStatus(String shopStatus) {
        this.shopStatus = shopStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShopEntity that = (ShopEntity) o;
        return shopId == that.shopId &&
                Objects.equals(shopName, that.shopName) &&
                Objects.equals(shopPwd, that.shopPwd) &&
                Objects.equals(shopAddress, that.shopAddress) &&
                Objects.equals(shopTel, that.shopTel) &&
                Objects.equals(shopCore, that.shopCore) &&
                Objects.equals(shopNotice, that.shopNotice) &&
                Objects.equals(shopTrademark, that.shopTrademark) &&
                Objects.equals(shopStatus, that.shopStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shopId, shopName, shopPwd, shopAddress, shopTel, shopCore, shopNotice, shopTrademark, shopStatus);
    }


}
