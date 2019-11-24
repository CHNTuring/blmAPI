package cn.zucc.edu.blm.bean;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "recipe", schema = "blm")
public class RecipeEntity {
    private Integer recipeId;
    private Integer shopId;
    private String recipeName;
    private Double recipePrice;
    private Integer monthlySale;
    private String recipeNotice;
    private String recipeImage;
    private Integer recipeRemain;
    private Double recipeDiscount;
    private String recipeStatus;


    @Id
    @Column(name = "recipe_id")
    public int getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
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
    @Column(name = "recipe_name")
    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
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
    @Column(name = "monthly_sale")
    public Integer getMonthlySale() {
        return monthlySale;
    }

    public void setMonthlySale(Integer monthlySale) {
        this.monthlySale = monthlySale;
    }

    @Basic
    @Column(name = "recipe_notice")
    public String getRecipeNotice() {
        return recipeNotice;
    }

    public void setRecipeNotice(String recipeNotice) {
        this.recipeNotice = recipeNotice;
    }

    @Basic
    @Column(name = "recipe_image")
    public String getRecipeImage() {
        return recipeImage;
    }

    public void setRecipeImage(String recipeImage) {
        this.recipeImage = recipeImage;
    }

    @Basic
    @Column(name = "recipe_remain")
    public Integer getRecipeRemain() {
        return recipeRemain;
    }

    public void setRecipeRemain(Integer recipeRemain) {
        this.recipeRemain = recipeRemain;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecipeEntity that = (RecipeEntity) o;
        return recipeId == that.recipeId &&
                Objects.equals(shopId, that.shopId) &&
                Objects.equals(recipeName, that.recipeName) &&
                Objects.equals(recipePrice, that.recipePrice) &&
                Objects.equals(monthlySale, that.monthlySale) &&
                Objects.equals(recipeNotice, that.recipeNotice) &&
                Objects.equals(recipeImage, that.recipeImage) &&
                Objects.equals(recipeRemain, that.recipeRemain) &&
                Objects.equals(recipeDiscount, that.recipeDiscount) &&
                Objects.equals(recipeStatus, that.recipeStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recipeId, shopId, recipeName, recipePrice, monthlySale, recipeNotice, recipeImage, recipeRemain, recipeDiscount, recipeStatus);
    }


}
