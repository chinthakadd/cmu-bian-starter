package edu.cmu.bian.model.PmtAddRq;

/*
Objective: This is an Card Response model class which would be used to create composite objects that are necessary
           for creating appropriate response message structures as per IFX.
           The class and variable names are consistent with the IFX naming conventions.
Created By: CMU BIAN-PNC Capstone Team
Last Update Date: 4/24/2017
*/


public class CardResponse {

    private Account account;
    private String gateway;
    private String partyId;

    public CardResponse() {
    }

    public CardResponse(Account account, String gateway, String partyId) {
        this.account = account;
        this.gateway = gateway;
        this.partyId = partyId;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccountId(Account account) {
        this.account = account;
    }

    public String getGateway() {
        return gateway;
    }

    public void setGateway(String gateway) {
        this.gateway = gateway;
    }

    public String getPartyId() {
        return partyId;
    }

    public void setPartyId(String partyId) {
        this.partyId = partyId;
    }
}
