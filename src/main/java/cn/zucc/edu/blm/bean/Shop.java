package cn.zucc.edu.blm.bean;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Arrays;
import java.util.Objects;

@Entity
public class Shop {
    private int shopId;
    private String shopName;
    private String shopPwd;
    private String shopAddress;
    private String shopTel;
    private Double shopCore;
    private String shopNotice;
    private byte[] shopTrademark;
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
    public byte[] getShopTrademark() {
        return shopTrademark;
    }

    public void setShopTrademark(byte[] shopTrademark) {
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
        Shop shop = (Shop) o;
        return shopId == shop.shopId &&
                Objects.equals(shopName, shop.shopName) &&
                Objects.equals(shopPwd, shop.shopPwd) &&
                Objects.equals(shopAddress, shop.shopAddress) &&
                Objects.equals(shopTel, shop.shopTel) &&
                Objects.equals(shopCore, shop.shopCore) &&
                Objects.equals(shopNotice, shop.shopNotice) &&
                Arrays.equals(shopTrademark, shop.shopTrademark) &&
                Objects.equals(shopStatus, shop.shopStatus);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(shopId, shopName, shopPwd, shopAddress, shopTel, shopCore, shopNotice, shopStatus);
        result = 31 * result + Arrays.hashCode(shopTrademark);
        return result;
    }
}
