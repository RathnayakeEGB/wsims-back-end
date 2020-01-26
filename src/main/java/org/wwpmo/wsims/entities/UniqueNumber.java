package org.wwpmo.wsims.entities;

import javax.persistence.*;


@Entity
@Table(name = "WSIMS_M_UNIQUE_NUMBERS")
public class UniqueNumber implements SuperEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int UniqueNumberSeq;

    @Column(unique = true,length = 6)
    private String sufix;

    private int nextNumber;

    @Column(unique = true)
    private int searchId;

    @Column(length = 30)
    private String description;


    public int getUniqueNumberSeq() {
        return UniqueNumberSeq;
    }

    public void setUniqueNumberSeq(int uniqueNumberSeq) {
        UniqueNumberSeq = uniqueNumberSeq;
    }

    public String getSufix() {
        return sufix;
    }

    public void setSufix(String sufix) {
        this.sufix = sufix;
    }

    public int getNextNumber() {
        return nextNumber;
    }

    public void setNextNumber(int nextNumber) {
        this.nextNumber = nextNumber;
    }

    public int getSearchId() {
        return searchId;
    }

    public void setSearchId(int searchId) {
        this.searchId = searchId;
    }

    public UniqueNumber(String sufix, int nextNumber, int searchId) {
        this.sufix = sufix;
        this.nextNumber = nextNumber;
        this.searchId = searchId;
    }

    public UniqueNumber() {
    }

    @Override
    public String toString() {
        return "UniqueNumber{" +
                "UniqueNumberSeq=" + UniqueNumberSeq +
                ", sufix='" + sufix + '\'' +
                ", nextNumber=" + nextNumber +
                ", searchId=" + searchId +
                '}';
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
