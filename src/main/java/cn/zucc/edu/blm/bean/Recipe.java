package cn.zucc.edu.blm.bean;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Arrays;
import java.util.Objects;

@Entity
public class Recipe {
    private int recipeId;
    private Integer shopId;
    private String recipeName;
    private Double recipePrice;
    private Integer monthlySale;
    private String recipeNotice;
    private byte[] recipeImage;
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
    public byte[] getRecipeImage() {
        return recipeImage;
    }

    public void setRecipeImage(byte[] recipeImage) {
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
        Recipe recipe = (Recipe) o;
        return recipeId == recipe.recipeId &&
                Objects.equals(shopId, recipe.shopId) &&
                Objects.equals(recipeName, recipe.recipeName) &&
                Objects.equals(recipePrice, recipe.recipePrice) &&
                Objects.equals(monthlySale, recipe.monthlySale) &&
                Objects.equals(recipeNotice, recipe.recipeNotice) &&
                Arrays.equals(recipeImage, recipe.recipeImage) &&
                Objects.equals(recipeRemain, recipe.recipeRemain) &&
                Objects.equals(recipeDiscount, recipe.recipeDiscount) &&
                Objects.equals(recipeStatus, recipe.recipeStatus);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(recipeId, shopId, recipeName, recipePrice, monthlySale, recipeNotice, recipeRemain, recipeDiscount, recipeStatus);
        result = 31 * result + Arrays.hashCode(recipeImage);
        return result;
    }
}
