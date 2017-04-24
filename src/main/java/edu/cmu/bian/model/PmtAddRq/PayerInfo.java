package edu.cmu.bian.model.PmtAddRq;

/*
Objective: This is a Payer Information class which would be used to create composite objects that are necessary
           for creating appropriate response message structures as per IFX.
           The class and variable names are consistent with the IFX naming conventions.
Created By: CMU BIAN-PNC Capstone Team
Last Update Date: 4/24/2017
*/


public class PayerInfo {

    private String payerAcctId;

    public PayerInfo() {

    }

    public PayerInfo(String payerAcctId) {

        this.payerAcctId = payerAcctId;
    }

    public String getPayerAcctId() {
        return payerAcctId;
    }

    public void setPayerAcctId(String payerAcctId) {
        this.payerAcctId = payerAcctId;
    }
}
