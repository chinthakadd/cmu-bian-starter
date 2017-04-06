package edu.cmu.bian.model.PmtAddRq;

/**
 * Created by chaitanyakvk on 3/27/2017.
 */
public class DepAcctIdFrom {

    private BankInfo bankInfo;
    private String acctId;
    private String acctType;
    private String acctCur;

    public DepAcctIdFrom(){

    }

    public DepAcctIdFrom(BankInfo bankInfo, String acctId, String acctType, String acctCur){
        this.bankInfo = bankInfo;
        this.acctId = acctId;
        this.acctType = acctType;
        this.acctCur = acctCur;
    }

    public BankInfo getBankInfo() {
        return bankInfo;
    }

    public void setBankInfo(BankInfo bankInfo) {
        this.bankInfo = bankInfo;
    }

    public String getAcctId() {
        return acctId;
    }

    public void setAcctId(String acctId) {
        this.acctId = acctId;
    }

    public String getAcctType() {
        return acctType;
    }

    public void setAcctType(String acctType) {
        this.acctType = acctType;
    }

    public String getAcctCur() {
        return acctCur;
    }

    public void setAcctCur(String acctCur) {
        this.acctCur = acctCur;
    }
}
