
package com.smile.mysupplier.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class MenuImage implements Serializable
{

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("menu_id")
    @Expose
    private String menuId;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("order")
    @Expose
    private String order;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private Object updatedAt;
    private final static long serialVersionUID = 896946817993850259L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public MenuImage() {
    }

    /**
     * 
     * @param updatedAt
     * @param id
     * @param order
     * @param createdAt
     * @param image
     * @param menuId
     */
    public MenuImage(Integer id, String menuId, String image, String order, String createdAt, Object updatedAt) {
        super();
        this.id = id;
        this.menuId = menuId;
        this.image = image;
        this.order = order;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

    public Object getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Object updatedAt) {
        this.updatedAt = updatedAt;
    }

}
