package edu.cmu.bian.model.PmtAddRq;

/*
Objective: This is a Loan Account Balance Inquiry Response model class which would be used to create composite objects that are necessary
           for creating appropriate response message structures as per IFX.
           The class and variable names are consistent with the IFX naming conventions.
Created By: CMU BIAN-PNC Capstone Team
Last Update Date: 4/24/2017
*/
public class LoanAcctBalInqRs {

    private String rqUID = new String();
    private DepAcctIdFrom depAcctIdFrom = new DepAcctIdFrom();
    private AcctBal acctBal = new AcctBal();
    public LoanAcctBalInqRs() {

    }

    public LoanAcctBalInqRs(String rqUID, DepAcctIdFrom depAcctIdFrom, AcctBal acctBal) {
        this.rqUID = rqUID;
        this.depAcctIdFrom = depAcctIdFrom;
        this.acctBal = acctBal;
    }

    public String getRqUID() {
        return rqUID;
    }

    public void setRqUID(String rqUID) {
        this.rqUID = rqUID;
    }

    public DepAcctIdFrom getDepAcctIdFrom() {
        return depAcctIdFrom;
    }

    public void setDepAcctIdFrom(DepAcctIdFrom depAcctIdFrom) {
        this.depAcctIdFrom = depAcctIdFrom;
    }

    public AcctBal getAcctBal() {
        return acctBal;
    }

    public void setAcctBal(AcctBal acctBal) {
        this.acctBal = acctBal;
    }
}
