package edu.cmu.bian.model.PmtAddRq;

/*
Objective: This is a Card Logical Data model class which would be used to create composite objects that are necessary
           for creating appropriate response message structures as per IFX.
           The class and variable names are consistent with the IFX naming conventions.
Created By: CMU BIAN-PNC Capstone Team
Last Update Date: 4/24/2017
*/

public class CardLogicalData {

    private String cardEmbossNum;
    private String brand;
    private String expDt;
    private String name;

    public CardLogicalData() {

    }

    public CardLogicalData(String cardEmbossNum, String brand, String expDt, String name) {
        this.cardEmbossNum = cardEmbossNum;
        this.brand = brand;
        this.expDt = expDt;
        this.name = name;
    }

    public String getCardEmbossNum() {
        return cardEmbossNum;
    }

    public void setCardEmbossNum(String cardEmbossNum) {
        this.cardEmbossNum = cardEmbossNum;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getExpDt() {
        return expDt;
    }

    public void setExpDt(String expDt) {
        this.expDt = expDt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
