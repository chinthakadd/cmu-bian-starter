package edu.cmu.bian.model.PmtAddRq;

/*
Objective: This is a Payment Add Request model class which would be used to create composite objects that are necessary
           for creating appropriate response message structures as per IFX.
           The class and variable names are consistent with the IFX naming conventions.
Created By: CMU BIAN-PNC Capstone Team
Last Update Date: 4/24/2017
*/

public class PmtAddRq {

    private CustId custId;
    private PmtInfo pmtInfo;
    private String rqUID;

    public PmtAddRq() {

    }

    public PmtAddRq(CustId custId, PmtInfo pmtInfo, String rqUID) {
        this.custId = custId;
        this.pmtInfo = pmtInfo;
        this.rqUID = rqUID;
    }

    public CustId getCustId() {
        return custId;
    }

    public void setCustId(CustId custId) {
        this.custId = custId;
    }

    public PmtInfo getPmtInfo() {
        return pmtInfo;
    }

    public void setPmtInfo(PmtInfo pmtInfo) {
        this.pmtInfo = pmtInfo;
    }

    public String getRqUID() {
        return rqUID;
    }

    public void setRqUID(String rqUID) {
        this.rqUID = rqUID;
    }
}
