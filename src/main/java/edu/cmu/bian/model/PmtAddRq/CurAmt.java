package edu.cmu.bian.model.PmtAddRq;

/*
Objective: This is an Currency-Amount model class which would be used to create composite objects that are necessary
           for creating appropriate response message structures as per IFX.
           The class and variable names are consistent with the IFX naming conventions.
Created By: CMU BIAN-PNC Capstone Team
Last Update Date: 4/24/2017
*/

public class CurAmt {

    private String curCode;
    private double amt;

    public CurAmt() {

    }

    public CurAmt(String curCode, double amt) {

        this.curCode = curCode;
        this.amt = amt;

    }

    public String getCurCode() {
        return curCode;
    }

    public void setCurCode(String curCode) {
        this.curCode = curCode;
    }

    public double getAmt() {
        return amt;
    }

    public void setAmt(double amt) {
        this.amt = amt;
    }
}
