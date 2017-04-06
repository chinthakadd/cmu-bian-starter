package edu.cmu.bian.model.PmtAddRq;

/**
 * Created by chaitanyakvk on 3/27/2017.
 */
public class CurAmt {

    private String curCode;
    private double amt;

    public CurAmt() {

    }

    public CurAmt(String curCode, double amt) {

        this.curCode = curCode;
        this.amt = amt;

    }

    public String getCurCode() {
        return curCode;
    }

    public void setCurCode(String curCode) {
        this.curCode = curCode;
    }

    public double getAmt() {
        return amt;
    }

    public void setAmt(double amt) {
        this.amt = amt;
    }
}
