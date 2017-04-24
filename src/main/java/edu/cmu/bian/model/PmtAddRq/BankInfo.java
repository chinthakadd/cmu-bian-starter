package edu.cmu.bian.model.PmtAddRq;

/*
Objective: This is an Bank Information model class which would be used to create composite objects that are necessary
           for creating appropriate response message structures as per IFX.
           The class and variable names are consistent with the IFX naming conventions.
Created By: CMU BIAN-PNC Capstone Team
Last Update Date: 4/24/2017
*/

public class BankInfo {

    private String bankIdType;
    private String bankId;
    private String name;
    private String branchId;
    private String branchName;


    public BankInfo() {

    }

    public BankInfo(String bankIdType, String bankId, String name, String branchId, String branchName) {

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
