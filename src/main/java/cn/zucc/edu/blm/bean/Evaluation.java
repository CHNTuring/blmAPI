package cn.zucc.edu.blm.bean;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Arrays;
import java.util.Objects;

@Entity
public class Evaluation {
    private int shopEvaluateId;
    private Integer shopId;
    private Integer userId;
    private Integer shopEvaluateOrder;
    private Double shopGrade;
    private String shopEvaluateContent;
    private byte[] shopEvaluateImage;
    private String userName;
    private byte[] userImage;

    @Id
    @Column(name = "shop_evaluate_id")
    public int getShopEvaluateId() {
        return shopEvaluateId;
    }

    public void setShopEvaluateId(int shopEvaluateId) {
        this.shopEvaluateId = shopEvaluateId;
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
    @Column(name = "shop_evaluate_order")
    public Integer getShopEvaluateOrder() {
        return shopEvaluateOrder;
    }

    public void setShopEvaluateOrder(Integer shopEvaluateOrder) {
        this.shopEvaluateOrder = shopEvaluateOrder;
    }

    @Basic
    @Column(name = "shop_grade")
    public Double getShopGrade() {
        return shopGrade;
    }

    public void setShopGrade(Double shopGrade) {
        this.shopGrade = shopGrade;
    }

    @Basic
    @Column(name = "shop_evaluate_content")
    public String getShopEvaluateContent() {
        return shopEvaluateContent;
    }

    public void setShopEvaluateContent(String shopEvaluateContent) {
        this.shopEvaluateContent = shopEvaluateContent;
    }

    @Basic
    @Column(name = "shop_evaluate_image")
    public byte[] getShopEvaluateImage() {
        return shopEvaluateImage;
    }

    public void setShopEvaluateImage(byte[] shopEvaluateImage) {
        this.shopEvaluateImage = shopEvaluateImage;
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
    @Column(name = "user_image")
    public byte[] getUserImage() {
        return userImage;
    }

    public void setUserImage(byte[] userImage) {
        this.userImage = userImage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Evaluation that = (Evaluation) o;
        return shopEvaluateId == that.shopEvaluateId &&
                Objects.equals(shopId, that.shopId) &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(shopEvaluateOrder, that.shopEvaluateOrder) &&
                Objects.equals(shopGrade, that.shopGrade) &&
                Objects.equals(shopEvaluateContent, that.shopEvaluateContent) &&
                Arrays.equals(shopEvaluateImage, that.shopEvaluateImage) &&
                Objects.equals(userName, that.userName) &&
                Arrays.equals(userImage, that.userImage);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(shopEvaluateId, shopId, userId, shopEvaluateOrder, shopGrade, shopEvaluateContent, userName);
        result = 31 * result + Arrays.hashCode(shopEvaluateImage);
        result = 31 * result + Arrays.hashCode(userImage);
        return result;
    }
}
