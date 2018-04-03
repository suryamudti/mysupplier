
package com.smile.mysupplier.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Locale;

public class Menu implements Serializable
{

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("menu_category_id")
    @Expose
    private String menuCategoryId;
    @SerializedName("is_hot_menu")
    @Expose
    private String isHotMenu;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("price")
    @Expose
    private String price;
    @SerializedName("order")
    @Expose
    private String order;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("is_wishlist")
    @Expose
    private Integer isWishlist;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("menu_image")
    @Expose
    private MenuImage menuImage;
    private final static long serialVersionUID = 6658543176581999825L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Menu() {
    }

    /**
     * 
     * @param updatedAt
     * @param isHotMenu
     * @param id
     * @param menuCategoryId
     * @param price
     * @param order
     * @param menuImage
     * @param createdAt
     * @param description
     * @param name
     * @param image
     * @param isWishlist
     */
    public Menu(Integer id, String menuCategoryId, String isHotMenu, String name, String description, String price, String order, String createdAt, String updatedAt, Integer isWishlist, String image, MenuImage menuImage) {
        super();
        this.id = id;
        this.menuCategoryId = menuCategoryId;
        this.isHotMenu = isHotMenu;
        this.name = name;
        this.description = description;
        this.price = price;
        this.order = order;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.isWishlist = isWishlist;
        this.image = image;
        this.menuImage = menuImage;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMenuCategoryId() {
        return menuCategoryId;
    }

    public void setMenuCategoryId(String menuCategoryId) {
        this.menuCategoryId = menuCategoryId;
    }

    public String getIsHotMenu() {
        return isHotMenu;
    }

    public void setIsHotMenu(String isHotMenu) {
        this.isHotMenu = isHotMenu;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getIsWishlist() {
        return isWishlist;
    }

    public void setIsWishlist(Integer isWishlist) {
        this.isWishlist = isWishlist;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public MenuImage getMenuImage() {
        return menuImage;
    }

    public void setMenuImage(MenuImage menuImage) {
        this.menuImage = menuImage;
    }

    public String getShortName() {
        return this.getCutDescription(this.getName(), 25);
    }

    public String getFormattedPrice() {
        Locale locale = new Locale("id", "ID");
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);

        return currencyFormatter.format(Double.parseDouble(this.getPrice()));
    }

    private String getCutDescription(String description, Integer cut) {
        if (description.length() > cut) {
            return description.substring(0, cut) + "...";
        }

        return description;
    }

}
