package edu.cmu.bian.model.PmtAddRq;

/**
 * Created by chaitanyakvk on 3/27/2017.
 */
public class PmtInfo {

    private PayerInfo payerInfo;

    private RemitInfo remitInfo;
    private DepAcctIdFrom depAcctIdFrom;
    private String prcDt, dueDt;


    public PmtInfo(){

    }

    public PmtInfo(PayerInfo payerInfo, RemitInfo remitInfo, DepAcctIdFrom depAcctIdFrom, String prcDt, String dueDt){
        this.payerInfo = payerInfo;
        this.remitInfo = remitInfo;
        this.depAcctIdFrom = depAcctIdFrom;
        this.prcDt = prcDt;
        this.dueDt = dueDt;

    }

    public PayerInfo getPayerInfo() {
        return payerInfo;
    }

    public void setPayerInfo(PayerInfo payerInfo) {
        this.payerInfo = payerInfo;
    }

    public RemitInfo getRemitInfo() {
        return remitInfo;
    }

    public void setRemitInfo(RemitInfo remitInfo) {
        this.remitInfo = remitInfo;
    }

    public DepAcctIdFrom getDepAcctIdFrom() {
        return depAcctIdFrom;
    }

    public void setDepAcctIdFrom(DepAcctIdFrom depAcctIdFrom) {
        this.depAcctIdFrom = depAcctIdFrom;
    }

    public String getPrcDt() {
        return prcDt;
    }

    public void setPrcDt(String prcDt) {
        this.prcDt = prcDt;
    }

    public String getDueDt() {
        return dueDt;
    }

    public void setDueDt(String dueDt) {
        this.dueDt = dueDt;
    }
}
