package edu.cmu.bian.model.PmtAddRq;

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
