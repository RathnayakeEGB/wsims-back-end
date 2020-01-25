package org.wwpmo.wsims.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "WSIMS_I_CUSTOMERS")
public class Customer implements SuperEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerSeq;

    @Column(length = 30,nullable = false,unique = true)
    private String customerReqNo;

    @Column(length = 150,nullable = false)
    private String nameWithInitials;

    @Column(length = 150,nullable = false)
    private  String fullName;

    @Column(length = 100,nullable = false)
    private String address;

    @Column(length = 100)
    private String address2;

    @Email
    @Column(length = 70,nullable = false)
    private String email;

    @Column(length = 12,nullable = false)
    private String nic;

    @Temporal(TemporalType.DATE)
    private Date registeredDate;

    @Column(length = 10,nullable = false)
    private String mobileNo;

    @Column(length = 10)
    private String teleNo;

    private int noOfFamilyMembers;

    @Column(length = 20,nullable = false)
    private String province;

    @Column(length = 1,nullable = false)
    private String status;

    @JsonIgnore
    private  String password;


    @Column(length = 40,nullable = false)
    private  String createdBy;

    @Column(length = 40)
    private String updatedBy;

    private LocalDateTime createdDate;

    private LocalDateTime UpdatedDate;

    @JoinColumn(name = "groupId",referencedColumnName = "customerGroupSeq")
    @ManyToOne
    private CustomerGroup groupId;

    public int getCustomerSeq() {
        return customerSeq;
    }

    public void setCustomerSeq(int customerSeq) {
        this.customerSeq = customerSeq;
    }

    public String getNameWithInitials() {
        return nameWithInitials;
    }

    public void setNameWithInitials(String nameWithInitials) {
        this.nameWithInitials = nameWithInitials;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public Date getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(Date registeredDate) {
        this.registeredDate = registeredDate;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getTeleNo() {
        return teleNo;
    }

    public void setTeleNo(String teleNo) {
        this.teleNo = teleNo;
    }

    public int getNoOfFamilyMembers() {
        return noOfFamilyMembers;
    }

    public void setNoOfFamilyMembers(int noOfFamilyMembers) {
        this.noOfFamilyMembers = noOfFamilyMembers;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public CustomerGroup getGroupId() {
        return groupId;
    }

    public void setGroupId(CustomerGroup groupId) {
        this.groupId = groupId;
    }

    public String getCustomerReqNo() {
        return customerReqNo;
    }

    public void setCustomerReqNo(String customerReqNo) {
        this.customerReqNo = customerReqNo;
    }

    public Customer() {
    }


    public Customer(String nameWithInitials, String customerReqNo, String fullName, String address, String address2, @Email String email, String nic, Date registeredDate, String mobileNo, String teleNo, int noOfFamilyMembers, String province, String status, String password, String createdBy, String updatedBy, LocalDateTime createdDate, LocalDateTime updatedDate) {
        this.nameWithInitials = nameWithInitials;
        this.customerReqNo =customerReqNo;
        this.fullName = fullName;
        this.address = address;
        this.address2 = address2;
        this.email = email;
        this.nic = nic;
        this.registeredDate = registeredDate;
        this.mobileNo = mobileNo;
        this.teleNo = teleNo;
        this.noOfFamilyMembers = noOfFamilyMembers;
        this.province = province;
        this.status = status;
        this.password = password;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
        this.createdDate = createdDate;
        UpdatedDate = updatedDate;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerSeq=" + customerSeq +
                ", nameWithInitials='" + nameWithInitials + '\'' +
                ", fullName='" + fullName + '\'' +
                ", address='" + address + '\'' +
                ", address2='" + address2 + '\'' +
                ", email='" + email + '\'' +
                ", nic='" + nic + '\'' +
                ", registeredDate=" + registeredDate +
                ", mobileNo='" + mobileNo + '\'' +
                ", teleNo='" + teleNo + '\'' +
                ", noOfFamilyMembers=" + noOfFamilyMembers +
                ", province='" + province + '\'' +
                ", status='" + status + '\'' +
                ", password='" + password + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", updatedBy='" + updatedBy + '\'' +
                ", createdDate=" + createdDate +
                ", UpdatedDate=" + UpdatedDate +
                ", groupId=" + groupId +
                '}';
    }
}
