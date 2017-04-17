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


@RestController
public class LoanAcctBalanceRequestController {

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
        RestTemplate restTemplate = new RestTemplate();
        DepAcctIdFrom depAcctIdFrom = new DepAcctIdFrom();
        BankInfo bankInfo = new BankInfo();
        AcctBal acctBal = new AcctBal();
        CurAmt curAmt = new CurAmt();
        LoanAcctBalInqRs loanAcctBalInqRs = new LoanAcctBalInqRs();

        bankInfo.setBankId(bankId);
        bankInfo.setBankIdType(bankIdType);
        bankInfo.setBranchId(branchId);
        bankInfo.setBranchName(branchName);
        bankInfo.setName(bankName);
        depAcctIdFrom.setAcctType(acctType);
        depAcctIdFrom.setBankInfo(bankInfo);
        depAcctIdFrom.setAcctId(accountId);
        String accounturl = "http://apimanager.pncapix.com:8280/smartbank-loan/1.0.0/loan/findByAccountId/{accountId}";
        Map<String, Object> accountparamMap = new HashMap<>();
        accountparamMap.put("accountId", accountId);
        MultiValueMap<String, Object> accountheaders = new LinkedMultiValueMap<>();
        accountheaders.add("Accept", "application/json");
        accountheaders.add("Authorization", "Bearer 4efe4573-3ed8-3c18-847a-b043869f1a45");
        HttpEntity accounthttpEntity = new HttpEntity(accountheaders);
        ResponseEntity<LoanAccount[]> accountResponseEntity =
                restTemplate.exchange(accounturl, HttpMethod.GET, accounthttpEntity, LoanAccount[].class, accountparamMap);
        LoanAccount[] account = accountResponseEntity.getBody();
        double balance = account[0].getTotalPrincipleAmnt() - account[0].getTotalRecPrncp();
        depAcctIdFrom.setAcctCur("USD");
        curAmt.setAmt(balance);
        curAmt.setCurCode("USD");
        acctBal.setCurAmt(curAmt);
        acctBal.setBalType("Ledger");
        loanAcctBalInqRs.setAcctBal(acctBal);
        loanAcctBalInqRs.setDepAcctIdFrom(depAcctIdFrom);
        loanAcctBalInqRs.setRqUID(rqUID);

        return loanAcctBalInqRs;
    }

}
