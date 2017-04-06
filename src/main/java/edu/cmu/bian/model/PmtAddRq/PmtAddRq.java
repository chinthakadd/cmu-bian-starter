package edu.cmu.bian.model.PmtAddRq;

/**
 * Created by chaitanyakvk on 3/27/2017.
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
