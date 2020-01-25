package org.wwpmo.wsims.entities.menu;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "LEVEL_3_MENU")
public class Menu3 implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int levelOneSeq;

    private int level;


    @Column(length = 20,unique = true)
    private String title;
    @Column(length = 40)
    private String icon ;

    private  boolean open;

    private boolean selected;

    private boolean  disabled;

    @Column(length = 200)
    private String routerLink;
    @Column(length = 2)
    private String isActive;

    @Column(length = 120)
    private String iconLocation;

    @ManyToOne
    @JoinColumn(referencedColumnName = "menuTwoSeq",name = "perentId")
    private  Menu2 parentId;

    public Menu3() {
    }



    public int getLevelOneSeq() {
        return levelOneSeq;
    }

    public void setLevelOneSeq(int levelOneSeq) {
        this.levelOneSeq = levelOneSeq;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
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



    public String getIconLocation() {
        return iconLocation;
    }

    public void setIconLocation(String icoLocation) {
        this.iconLocation = icoLocation;
    }

    public Menu2 getParentId() {
        return parentId;
    }

    public void setParentId(Menu2 parentId) {
        this.parentId = parentId;
    }


//

    @Override
    public String toString() {
        return "Menu3{" +
                "levelOneSeq=" + levelOneSeq +
                ", level=" + level +
                ", title='" + title + '\'' +
                ", icon='" + icon + '\'' +
                ", open=" + open +
                ", selected=" + selected +
                ", disabled=" + disabled +
                ", routerLink='" + routerLink + '\'' +
                ", isActive='" + isActive + '\'' +
                ", iconLocation='" + iconLocation + '\'' +
                ", parentId=" + parentId +
                '}';
    }
//    @Override
//    public String toString() {
//        return "LevelOneMenu{" +
//                "levelOneSeq=" + levelOneSeq +
//                ", level=" + level +
//                ", title='" + title + '\'' +
//                ", icon='" + icon + '\'' +
//                ", open=" + open +
//                ", selected=" + selected +
//                ", disabled=" + disabled +
//                ", routerLink='" + routerLink + '\'' +
//                ", isActive='" + isActive + '\'' +
//                ", icoLocation='" + iconLocation + '\'' +
//                '}';
//    }
}
