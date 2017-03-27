package edu.cmu.bian.model;

/**
 * Created by chaitanyakvk on 3/27/2017.
 */
public class PaymentModel {

    private int payeeAccountNumber;

    private int payerAccountNumber;

    public PaymentModel() {

    }

    public PaymentModel(int payeeAccountNumber, int payerAccountNumber) {
        this.payeeAccountNumber = payeeAccountNumber;
        this.payerAccountNumber = payerAccountNumber;
    }

    public int getPayeeAccountNumber() {
        return payeeAccountNumber;
    }

    public void setPayeeAccountNumber(int payeeAccountNumber) {
        this.payeeAccountNumber = payeeAccountNumber;
    }

    public int getPayerAccountNumber() {
        return payerAccountNumber;
    }

    public void setPayerAccountNumber(int payerAccountNumber) {
        this.payerAccountNumber = payerAccountNumber;
    }
}
