package edu.cmu.bian.model.PmtAddRq;

/*
Objective: This is a Remit Information model class which would be used to create composite objects that are necessary
           for creating appropriate response message structures as per IFX.
           The class and variable names are consistent with the IFX naming conventions.
Created By: CMU BIAN-PNC Capstone Team
Last Update Date: 4/24/2017
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
