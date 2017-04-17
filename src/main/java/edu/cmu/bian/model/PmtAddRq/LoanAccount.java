package edu.cmu.bian.model.PmtAddRq;

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

