package edu.cmu.bian.model.PmtAddRq;

/**
 * Created by chaitanyakvk on 3/27/2017.
 */
public class CustId {

    private CardLogicalData cardLogicalData;
    private String custLoginId;

    public CustId() {

    }

    public CustId(CardLogicalData cardLogicalData, String custLoginId) {
        this.cardLogicalData = cardLogicalData;
        this.custLoginId = custLoginId;
    }

    public CardLogicalData getCardLogicalData() {
        return cardLogicalData;
    }

    public void setCardLogicalData(CardLogicalData cardLogicalData) {
        this.cardLogicalData = cardLogicalData;
    }

    public String getCustLoginId() {
        return custLoginId;
    }

    public void setCustLoginId(String custLoginId) {
        this.custLoginId = custLoginId;
    }
}

