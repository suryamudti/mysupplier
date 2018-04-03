
package com.smile.mysupplier.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class MenuCategory implements Serializable
{

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
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
    private String updatedAt;
    @SerializedName("hot_menus")
    @Expose
    private List<Menu> menus = null;
    private final static long serialVersionUID = 1969854603569944722L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public MenuCategory() {
    }

    /**
     *
     * @param updatedAt
     * @param id
     * @param order
     * @param createdAt
     * @param name
     * @param image
     */
    public MenuCategory(Integer id, String name, String image, String order, String createdAt, String updatedAt) {
        super();
        this.id = id;
        this.name = name;
        this.image = image;
        this.order = order;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    /**
     * 
     * @param menus
     * @param updatedAt
     * @param id
     * @param order
     * @param createdAt
     * @param name
     * @param image
     */
    public MenuCategory(Integer id, String name, String image, String order, String createdAt, String updatedAt, List<Menu> menus) {
        super();
        this.id = id;
        this.name = name;
        this.image = image;
        this.order = order;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.menus = menus;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

    public String getShortName() {
        return this.getCutDescription(this.getName(), 20);
    }

    private String getCutDescription(String description, Integer cut) {
        if (description.length() > cut) {
            return description.substring(0, cut) + "...";
        }

        return description;
    }

}
