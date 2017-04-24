package edu.cmu.bian.model.PmtAddRq;

/*
Objective: This is an Account Balance model class which would be used to create composite objects that are necessary
           for creating appropriate response message structures as per IFX.
           The class and variable names are consistent with the IFX naming conventions.
Created By: CMU BIAN-PNC Capstone Team
Last Update Date: 4/24/2017
*/

public class AcctBal {

    private CurAmt curAmt;
    private String BalType;

    public AcctBal(){

    }

    public AcctBal(CurAmt curAmt, String balType) {
        this.curAmt = curAmt;
        BalType = balType;
    }

    public CurAmt getCurAmt() {
        return curAmt;
    }

    public void setCurAmt(CurAmt curAmt) {
        this.curAmt = curAmt;
    }

    public String getBalType() {
        return BalType;
    }

    public void setBalType(String balType) {
        BalType = balType;
    }
}
