package edu.cmu.bian.model;

public class Account {

    private long accountId;

    public Account() {
    }

    public Account(long accountId) {
        this.accountId = accountId;
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }
}
