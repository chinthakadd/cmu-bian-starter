package edu.cmu.bian.model.PmtAddRq;

/**
 * Created by chaitanyakvk on 3/27/2017.
 */
public class CardAccount {

    private CardLogicalData cardLogicalData;
    private String acctType;

    public CardAccount(){

    }

    public CardAccount(CardLogicalData cardLogicalData, String acctType) {
        this.cardLogicalData = cardLogicalData;
        this.acctType = acctType;
    }

    public CardLogicalData getCardLogicalData() {
        return cardLogicalData;
    }

    public void setCardLogicalData(CardLogicalData cardLogicalData) {
        this.cardLogicalData = cardLogicalData;
    }

    public String getAcctType() {
        return acctType;
    }

    public void setAcctType(String acctType) {
        this.acctType = acctType;
    }
}
