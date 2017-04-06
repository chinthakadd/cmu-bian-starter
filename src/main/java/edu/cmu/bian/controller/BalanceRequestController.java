package edu.cmu.bian.controller;

import edu.cmu.bian.model.PmtAddRq.*;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;


@RestController
public class PaymentRequestController {

    @PostMapping("/pmtAddRq")
    public PmtAddRq paymentAddRequest(@RequestBody PmtAddRqInput pmtAddRqInput) {

        PmtAddRq pmtAddRqResponse = new PmtAddRq();
        PayerInfo payerInfo = new PayerInfo();
        CurAmt curAmt = new CurAmt();
        BankInfo bankInfo = new BankInfo();
        RemitInfo remitInfo = new RemitInfo();
        RestTemplate restTemplate = new RestTemplate();
        DepAcctIdFrom depAcctIdFrom = new DepAcctIdFrom();
        CustId custId = new CustId();
        PmtInfo pmtInfo = new PmtInfo();
        CardLogicalData cardLogicalData = new CardLogicalData();


        String url = "http://apimanager.pncapix.com:8280/SmartBank-API-Services/V2.0/card/findByCardNumber/{cardNumber}";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("cardNumber", pmtAddRqInput.getCardEmbossNum());
        MultiValueMap<String, Object> headers = new LinkedMultiValueMap<>();
        headers.add("Accept", "application/json");
        headers.add("Authorization", "Bearer 16cd1907-6dfd-33ab-b196-9d8419333f3d");
        HttpEntity httpEntity = new HttpEntity(headers);
        ResponseEntity<CardResponse[]> cardResponseEntity =
                restTemplate.exchange(url, HttpMethod.GET, httpEntity, CardResponse[].class, paramMap);
        CardResponse[] cardResponse = cardResponseEntity.getBody();

        curAmt.setAmt(pmtAddRqInput.getAmt());
        curAmt.setCurCode(pmtAddRqInput.getCurCode());
        remitInfo.setCurAmt(curAmt);
        bankInfo.setBankId(pmtAddRqInput.getBankId());
        bankInfo.setBankIdType(pmtAddRqInput.getBankIdType());
        bankInfo.setBranchId(pmtAddRqInput.getBranchId());
        bankInfo.setBranchName(pmtAddRqInput.getBranchName());
        bankInfo.setName(pmtAddRqInput.getBankName());
        depAcctIdFrom.setAcctCur(pmtAddRqInput.getPayeeAcctCur());
        depAcctIdFrom.setAcctType(pmtAddRqInput.getPayeeAcctType());
        depAcctIdFrom.setBankInfo(bankInfo);
        depAcctIdFrom.setAcctId(pmtAddRqInput.getPayeeAcctId());
        payerInfo.setPayerAcctId(cardResponse[0].getAccount().getAccountId());
        pmtInfo.setDepAcctIdFrom(depAcctIdFrom);
        pmtInfo.setPayerInfo(payerInfo);
        pmtInfo.setRemitInfo(remitInfo);
        pmtInfo.setDueDt(pmtAddRqInput.getDueDt());
        pmtInfo.setPrcDt(pmtAddRqInput.getPrcDt());
        cardLogicalData.setBrand(cardResponse[0].getGateway());
        cardLogicalData.setCardEmbossNum(pmtAddRqInput.getCardEmbossNum());
        cardLogicalData.setExpDt(pmtAddRqInput.getExpDt());
        cardLogicalData.setName(pmtAddRqInput.getCardEmbossName());
        custId.setCardLogicalData(cardLogicalData);
        custId.setCustLoginId(cardResponse[0].getPartyId()); // need to change this to Cust Login ID
        pmtAddRqResponse.setPmtInfo(pmtInfo);
        pmtAddRqResponse.setCustId(custId);
        pmtAddRqResponse.setRqUID(pmtAddRqInput.getRqUID());


        String accounturl = "http://apimanager.pncapix.com:8280/smartbank-account/1.0.0/account/{accountId}";
        Map<String, Object> accountparamMap = new HashMap<>();
        accountparamMap.put("accountId", cardResponse[0].getAccount().getAccountId());
        MultiValueMap<String, Object> accountheaders = new LinkedMultiValueMap<>();
        accountheaders.add("Accept", "application/json");
        accountheaders.add("Authorization", "Bearer 4efe4573-3ed8-3c18-847a-b043869f1a45");
        HttpEntity accounthttpEntity = new HttpEntity(accountheaders);
        ResponseEntity<String> accountResponseEntity =
                restTemplate.exchange(accounturl, HttpMethod.GET, accounthttpEntity, String.class, accountparamMap);
        String accountbal = accountResponseEntity.getBody();

        System.out.println(accountbal);
        return pmtAddRqResponse;
    }

}
