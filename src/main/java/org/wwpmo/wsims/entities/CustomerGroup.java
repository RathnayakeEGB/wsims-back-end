package org.wwpmo.wsims.entities;

import net.bytebuddy.implementation.bind.annotation.Super;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "WSIMS_M_CUSTOMER_GROUPS")
public class CustomerGroup implements SuperEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerGroupSeq;

    @Column(length = 30,nullable = false,unique = true)
    private String customerGroupNo;

    @Column(length = 30,nullable = false,unique = true)
    private String customerGroupName;

    @Column(length = 100)
    private String description;

    @Column(length = 1,nullable = false)
    private String isActive;

    @Column(length = 40,nullable = false)
    private  String createdBy;

    @Column(length = 40)
    private String updatedBy;

    private LocalDateTime createdDate;

    private LocalDateTime UpdatedDate;

    public int getCustomerGroupSeq() {
        return customerGroupSeq;
    }

    public void setCustomerGroupSeq(int customerGroupSeq) {
        this.customerGroupSeq = customerGroupSeq;
    }

    public String getCustomerGroupName() {
        return customerGroupName;
    }

    public void setCustomerGroupName(String customerGroupName) {
        this.customerGroupName = customerGroupName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getUpdatedDate() {
        return UpdatedDate;
    }

    public void setUpdatedDate(LocalDateTime updatedDate) {
        UpdatedDate = updatedDate;
    }

    public String getCustomerGroupNo() {
        return customerGroupNo;
    }

    public void setCustomerGroupNo(String customerGroupNo) {
        this.customerGroupNo = customerGroupNo;
    }

    public CustomerGroup(String customerGroupName, String description, String isActive, String createdBy, String updatedBy, LocalDateTime createdDate, LocalDateTime updatedDate) {
        this.customerGroupName = customerGroupName;
        this.description = description;
        this.isActive = isActive;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
        this.createdDate = createdDate;
        UpdatedDate = updatedDate;
    }

    public CustomerGroup() {
    }

    @Override
    public String toString() {
        return "CustomerGroup{" +
                "customerGroupSeq=" + customerGroupSeq +
                ", customerGroupName='" + customerGroupName + '\'' +
                ", description='" + description + '\'' +
                ", isActive='" + isActive + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", updatedBy='" + updatedBy + '\'' +
                ", createdDate=" + createdDate +
                ", UpdatedDate=" + UpdatedDate +
                '}';
    }
}
