package edu.cmu.bian.model.PmtAddRq;

/*
Objective: This is a Loan Account model class which would be used to create composite objects that are necessary
           for creating appropriate response message structures as per IFX.
           The class and variable names are consistent with the IFX naming conventions.
Created By: CMU BIAN-PNC Capstone Team
Last Update Date: 4/24/2017
*/

public class LoanAccount {

    private double totalPrincipleAmnt;
    private double totalRecPrncp;
    public LoanAccount() {
    }

    public LoanAccount(double totalPrincipleAmnt, double totalRecPrncp) {
        this.totalPrincipleAmnt = totalPrincipleAmnt;
        this.totalRecPrncp = totalRecPrncp;
    }

    public double getTotalPrincipleAmnt() {
        return totalPrincipleAmnt;
    }

    public void setTotalPrincipleAmnt(double totalPrincipleAmnt) {
        this.totalPrincipleAmnt = totalPrincipleAmnt;
    }

    public double getTotalRecPrncp() {
        return totalRecPrncp;
    }

    public void setTotalRecPrncp(double totalRecPrncp) {
        this.totalRecPrncp = totalRecPrncp;
    }
}

