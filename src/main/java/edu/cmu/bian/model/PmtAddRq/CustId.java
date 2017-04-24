package edu.cmu.bian.model.PmtAddRq;

/*
Objective: This is a Customer ID model class which would be used to create composite objects that are necessary
           for creating appropriate response message structures as per IFX.
           The class and variable names are consistent with the IFX naming conventions.
Created By: CMU BIAN-PNC Capstone Team
Last Update Date: 4/24/2017
*/

public class CustId {

    private CardLogicalData cardLogicalData;
    private String custLoginId;

    public CustId() {

    }

    public CustId(CardLogicalData cardLogicalData, String custLoginId) {
        this.cardLogicalData = cardLogicalData;
        this.custLoginId = custLoginId;
    }

    public CardLogicalData getCardLogicalData() {
        return cardLogicalData;
    }

    public void setCardLogicalData(CardLogicalData cardLogicalData) {
        this.cardLogicalData = cardLogicalData;
    }

    public String getCustLoginId() {
        return custLoginId;
    }

    public void setCustLoginId(String custLoginId) {
        this.custLoginId = custLoginId;
    }
}

