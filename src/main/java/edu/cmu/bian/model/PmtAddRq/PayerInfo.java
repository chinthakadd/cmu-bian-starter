package edu.cmu.bian.model.PmtAddRq;

/**
 * Created by chaitanyakvk on 3/27/2017.
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
