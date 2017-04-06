package edu.cmu.bian.model.PmtAddRq;

/**
 * Created by chaitanyakvk on 3/27/2017.
 */
public class PmtAddRqInput {


    private String rqUID;
    private String cardEmbossNum;
    private String expDt;
    private String cardEmbossName;
    private String payeeAcctId;
    private String payeeAcctType;
    private String payeeAcctCur;
    private String prcDt;
    private String dueDt;
    private double amt;
    private String curCode;
    private String bankIdType;
    private String bankId;
    private String bankName;
    private String branchId;
    private String branchName;

    public PmtAddRqInput() {

    }

    public PmtAddRqInput(String rqUID, String cardEmbossNum, String expDt, String cardEmbossName, String payeeAcctId, String payeeAcctType, String payeeAcctCur, String prcDt, String dueDt, double amt, String curCode, String bankIdType, String bankId, String bankName, String branchId, String branchName) {
        this.rqUID = rqUID;
        this.cardEmbossNum = cardEmbossNum;
        this.expDt = expDt;
        this.cardEmbossName = cardEmbossName;
        this.payeeAcctId = payeeAcctId;
        this.payeeAcctType = payeeAcctType;
        this.payeeAcctCur = payeeAcctCur;
        this.prcDt = prcDt;
        this.dueDt = dueDt;
        this.amt = amt;
        this.curCode = curCode;
        this.bankIdType = bankIdType;
        this.bankId = bankId;
        this.bankName = bankName;
        this.branchId = branchId;
        this.branchName = branchName;
    }

    public String getRqUID() {
        return rqUID;
    }

    public void setRqUID(String rqUID) {
        this.rqUID = rqUID;
    }

    public String getCardEmbossNum() {
        return cardEmbossNum;
    }

    public void setCardEmbossNum(String cardEmbossNum) {
        this.cardEmbossNum = cardEmbossNum;
    }

    public String getExpDt() {
        return expDt;
    }

    public void setExpDt(String expDt) {
        this.expDt = expDt;
    }

    public String getCardEmbossName() {
        return cardEmbossName;
    }

    public void setCardEmbossName(String cardEmbossName) {
        this.cardEmbossName = cardEmbossName;
    }

    public String getPayeeAcctId() {
        return payeeAcctId;
    }

    public void setPayeeAcctId(String payeeAcctId) {
        this.payeeAcctId = payeeAcctId;
    }

    public String getPayeeAcctType() {
        return payeeAcctType;
    }

    public void setPayeeAcctType(String payeeAcctType) {
        this.payeeAcctType = payeeAcctType;
    }

    public String getPayeeAcctCur() {
        return payeeAcctCur;
    }

    public void setPayeeAcctCur(String payeeAcctCur) {
        this.payeeAcctCur = payeeAcctCur;
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

    public double getAmt() {
        return amt;
    }

    public void setAmt(double amt) {
        this.amt = amt;
    }

    public String getCurCode() {
        return curCode;
    }

    public void setCurCode(String curCode) {
        this.curCode = curCode;
    }

    public String getBankIdType() {
        return bankIdType;
    }

    public void setBankIdType(String bankIdType) {
        this.bankIdType = bankIdType;
    }

    public String getBankId() {
        return bankId;
    }

    public void setBankId(String bankId) {
        this.bankId = bankId;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBranchId() {
        return branchId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }
}
