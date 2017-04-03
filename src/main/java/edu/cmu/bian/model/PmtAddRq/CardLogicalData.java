package edu.cmu.bian.model.PmtAddRq;

/**
 * Created by chaitanyakvk on 3/27/2017.
 */
public class CardLogicalData {

    private String bankIdType;
    private String bankId;
    private String name;
    private String branchId;
    private String branchName;


    public CardLogicalData() {

    }

    public CardLogicalData(String bankIdType, String bankId, String name, String branchId, String branchName) {

        this.bankIdType = bankIdType;
        this.bankId = bankId;
        this.branchId = branchId;
        this.branchName = branchName;
        this.name = name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
