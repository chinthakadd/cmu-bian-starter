package edu.cmu.bian.model.PmtAddRq;

/**
 * Created by chaitanyakvk on 3/27/2017.
 */
public class AcctBal {

    private CurAmt curAmt;
    private String BalType;

    public AcctBal(){

    }

    public AcctBal(CurAmt curAmt, String balType) {
        this.curAmt = curAmt;
        BalType = balType;
    }

    public CurAmt getCurAmt() {
        return curAmt;
    }

    public void setCurAmt(CurAmt curAmt) {
        this.curAmt = curAmt;
    }

    public String getBalType() {
        return BalType;
    }

    public void setBalType(String balType) {
        BalType = balType;
    }
}
