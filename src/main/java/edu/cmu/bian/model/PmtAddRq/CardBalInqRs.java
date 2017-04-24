package edu.cmu.bian.model.PmtAddRq;

/*
Objective: This is an Card Balance Inquiry Response model class which would be used to create composite objects that are necessary
           for creating appropriate response message structures as per IFX.
           The class and variable names are consistent with the IFX naming conventions.
Created By: CMU BIAN-PNC Capstone Team
Last Update Date: 4/24/2017
*/
public class CardBalInqRs {

    private String rqUID = new String();
    private CardAccount cardAccount = new CardAccount();
    private AcctBal balance = new AcctBal();
    public CardBalInqRs() {

    }

    public CardBalInqRs(String rqUID, CardAccount cardAccount, AcctBal balance) {
        this.rqUID = rqUID;
        this.cardAccount = cardAccount;
        this.balance = balance;
    }

    public String getRqUID() {
        return rqUID;
    }

    public void setRqUID(String rqUID) {
        this.rqUID = rqUID;
    }

    public CardAccount getCardAccount() {
        return cardAccount;
    }

    public void setCardAccount(CardAccount cardAccount) {
        this.cardAccount = cardAccount;
    }

    public AcctBal getBalance() {
        return balance;
    }

    public void setBalance(AcctBal balance) {
        this.balance = balance;
    }
}
