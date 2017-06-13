//Import Statements
package edu.cmu.bian.controller;
import edu.cmu.bian.model.PmtAddRq.*;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import java.util.HashMap;
import java.util.Map;


/*
Business Use Case: This caters to the account information service provider (AISP) requirement of the PSD2.
Objective: The Loan Account Balance Request Controller provides the end point for the TPP to get Balance of a Loan Account.
           It looks up the PNC API Exchange to fill a few additional fields based on the parameters sent by the TPP.
           An IFX Compliant JSON response is built and echoed back.
Created By: CMU BIAN-PNC Capstone Team
Last Update Date: 4/24/2017
*/


@RestController
public class LoanAcctBalanceRequestController {

    //GET request for retrieving balance
    @GetMapping("/LoanAcctBalRq/{rqUID}/{accountId}/{acctType}/{bankIdType}/{bankId}/{bankName}/{branchId}/{branchName}")
    public LoanAcctBalInqRs LoanAcctBalanceRequest(@PathVariable("accountId") String accountId,
                                                 @PathVariable("rqUID") String rqUID,
                                                 @PathVariable("acctType") String acctType,
                                                 @PathVariable("bankIdType") String bankIdType,
                                                 @PathVariable("bankId") String bankId,
                                                 @PathVariable("bankName") String bankName,
                                                 @PathVariable("branchId") String branchId,
                                                 @PathVariable("branchName") String branchName
    ) {
        //Objects required to build the IFX compliant response
        RestTemplate restTemplate = new RestTemplate();
        DepAcctIdFrom depAcctIdFrom = new DepAcctIdFrom();
        BankInfo bankInfo = new BankInfo();
        AcctBal acctBal = new AcctBal();
        CurAmt curAmt = new CurAmt();
        LoanAcctBalInqRs loanAcctBalInqRs = new LoanAcctBalInqRs();

        //Code to access the PNC API Exchange to retrieve details based on Loan Account Number
        String accounturl = "http://azureapimanager.pncapix.com:8280/SmartBank-Loan-Services/v1.0.0/loan/findByAccountId/{accountId}";

        //Map to store the Parameters that are to be passed
        Map<String, Object> accountparamMap = new HashMap<>();
        accountparamMap.put("accountId", accountId);

        //Map to store the headers required for the API Access
        MultiValueMap<String, Object> accountheaders = new LinkedMultiValueMap<>();
        accountheaders.add("Accept", "application/json");
        accountheaders.add("Authorization", "Bearer abd3e694-8f10-3f8a-9cec-90ea0e3bc96e");
        HttpEntity accounthttpEntity = new HttpEntity(accountheaders);

        // Sending the request to the PNC API Exchange
        ResponseEntity<LoanAccount[]> accountResponseEntity =
                restTemplate.exchange(accounturl, HttpMethod.GET, accounthttpEntity, LoanAccount[].class, accountparamMap);

        // Response stored in an object built as per the PNC API Response body JSON Structure
        LoanAccount[] account = accountResponseEntity.getBody();

        //Calculating the loan balance
        double balance = account[0].getTotalPrincipleAmnt() - account[0].getTotalRecPrncp();

        // Building the target response structure which is IFX Compliant
        bankInfo.setBankId(bankId);
        bankInfo.setBankIdType(bankIdType);
        bankInfo.setBranchId(branchId);
        bankInfo.setBranchName(branchName);
        bankInfo.setName(bankName);
        depAcctIdFrom.setAcctType(acctType);
        depAcctIdFrom.setBankInfo(bankInfo);
        depAcctIdFrom.setAcctId(accountId);
        depAcctIdFrom.setAcctCur("USD");
        curAmt.setAmt(balance);
        curAmt.setCurCode("USD");
        acctBal.setCurAmt(curAmt);
        acctBal.setBalType("Ledger");
        loanAcctBalInqRs.setAcctBal(acctBal);
        loanAcctBalInqRs.setDepAcctIdFrom(depAcctIdFrom);
        loanAcctBalInqRs.setRqUID(rqUID);

        //Return the JSON response
        return loanAcctBalInqRs;
    }

}
