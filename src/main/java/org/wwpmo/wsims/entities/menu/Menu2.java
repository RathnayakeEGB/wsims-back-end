package org.wwpmo.wsims.entities.menu;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "LEVEL_2_MENU")
public class Menu2 implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int menuTwoSeq;

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

    @ManyToOne
    @JoinColumn(name = "parentId",referencedColumnName = "menuSeq")
    private Menu parentId;

    @Column(length = 120)
    private String iconLocation;

    @OneToMany()
    private List<Menu3> children;


    public List<Menu3> getChildren() {
        return children;
    }

    public void setChildren(List<Menu3> children) {
        this.children = children;
    }


    public Menu2() {
    }

    public String getIconLocation() {
        return iconLocation;
    }

    public void setIconLocation(String icoLocation) {
        this.iconLocation = icoLocation;
    }

    public int getMenuTwoSeq() {
        return menuTwoSeq;
    }

    public void setMenuTwoSeq(int menuTwoSeq) {
        this.menuTwoSeq = menuTwoSeq;
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

    public Menu getParentId() {
        return parentId;
    }

    public void setParentId(Menu parentId) {
        this.parentId = parentId;
    }

    @Override
    public String toString() {
        return "Menu2{" +
                "menuTwoSeq=" + menuTwoSeq +
                ", level=" + level +
                ", title='" + title + '\'' +
                ", icon='" + icon + '\'' +
                ", open=" + open +
                ", selected=" + selected +
                ", disabled=" + disabled +
                ", routerLink='" + routerLink + '\'' +
                ", isActive='" + isActive + '\'' +
                ", parentId=" + parentId +
                ", iconLocation='" + iconLocation + '\'' +
                ", children=" + children +
                '}';
    }
}
