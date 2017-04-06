package edu.cmu.bian.model.PmtAddRq;

/**
 * Created by chaitanyakvk on 3/27/2017.
 */
public class RemitInfo {

    private CurAmt curAmt;

    public RemitInfo(){

    }

    public RemitInfo(CurAmt curAmt){
        this.curAmt = curAmt;
    }

    public CurAmt getCurAmt() {
        return curAmt;
    }

    public void setCurAmt(CurAmt curAmt) {
        this.curAmt = curAmt;
    }
}
