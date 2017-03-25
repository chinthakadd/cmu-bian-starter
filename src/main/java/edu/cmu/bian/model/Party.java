package edu.cmu.bian.model;

public class Party {

    private long partyId;
    private String active;


    public Party() {
    }

    public Party(long partyId) {
        this.partyId = partyId;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public long getPartyId() {
        return partyId;
    }

    public void setPartyId(long partyId) {
        this.partyId = partyId;
    }

    @Override
    public String toString() {
        return "Party{" +
                "partyId=" + partyId +
                ", active='" + active + '\'' +
                '}';
    }
}
