package org.wwpmo.wsims.entities.menu;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "LEVEL_1_MENU")
public class Menu implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int menuSeq;

    private int level;

    @Column(length = 20,unique = true)
    private String title;
    @Column(length = 20)
    private String icon ;

    private  boolean open;

    private boolean selected;

    private boolean  disabled;

    @Column(length = 100)
    private String routerLink;
    @Column(length = 2)
    private String isActive;

    private String iconLocation;


    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Menu2> children;

    public String getIconLocation() {
        return iconLocation;
    }

    public void setIconLocation(String icoLocation) {
        this.iconLocation = icoLocation;
    }

    public List<Menu2> getChildren() {
        return children;
    }

    public void setChildren(List<Menu2> children) {
        this.children = children;
    }


    public Menu() {
    }

    public int getMenuSeq() {
        return menuSeq;
    }

    public void setMenuSeq(int menuSeq) {
        this.menuSeq = menuSeq;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public String getRouterLink() {
        return routerLink;
    }

    public void setRouterLink(String routerLink) {
        this.routerLink = routerLink;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }


    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }


    @Override
    public String toString() {
        return "Menu{" +
                "menuSeq=" + menuSeq +
                ", level=" + level +
                ", title='" + title + '\'' +
                ", icon='" + icon + '\'' +
                ", open=" + open +
                ", selected=" + selected +
                ", disabled=" + disabled +
                ", routerLink='" + routerLink + '\'' +
                ", isActive='" + isActive + '\'' +
                ", iconLocation='" + iconLocation + '\'' +
                ", children=" + children +
                '}';
    }
}
