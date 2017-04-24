package edu.cmu.bian.model.PmtAddRq;

/*
Objective: This is an Card Account model class which would be used to create composite objects that are necessary
           for creating appropriate response message structures as per IFX.
           The class and variable names are consistent with the IFX naming conventions.
Created By: CMU BIAN-PNC Capstone Team
Last Update Date: 4/24/2017
*/
public class CardAccount {

    private CardLogicalData cardLogicalData;
    private String acctType;

    public CardAccount(){

    }

    public CardAccount(CardLogicalData cardLogicalData, String acctType) {
        this.cardLogicalData = cardLogicalData;
        this.acctType = acctType;
    }

    public CardLogicalData getCardLogicalData() {
        return cardLogicalData;
    }

    public void setCardLogicalData(CardLogicalData cardLogicalData) {
        this.cardLogicalData = cardLogicalData;
    }

    public String getAcctType() {
        return acctType;
    }

    public void setAcctType(String acctType) {
        this.acctType = acctType;
    }
}
