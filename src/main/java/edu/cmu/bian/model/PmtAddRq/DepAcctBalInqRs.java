package edu.cmu.bian.model.PmtAddRq;

/**
 * Created by chaitanyakvk on 3/27/2017.
 */
public class DepAcctBalInqRs {

    private String rqUID = new String();
    private DepAcctIdFrom depAcctIdFrom = new DepAcctIdFrom();
    private AcctBal acctBal = new AcctBal();
    public DepAcctBalInqRs() {

    }

    public DepAcctBalInqRs(String rqUID, DepAcctIdFrom depAcctIdFrom, AcctBal acctBal) {
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
