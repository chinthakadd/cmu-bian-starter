//Import Statements
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

/*
Business Use Case: This caters to the payment initiation service provider (PISP) requirement of the PSD2.
Objective: The Payment Request Controller provides the end point for the TPP to Access and Initiate a payment.
           It looks up the PNC API Exchange to fill a few additional fields based on the parameters sent by the TPP.
           An IFX Compliant JSON response is built and echoed back.
Created By: CMU BIAN-PNC Capstone Team
Last Update Date: 4/24/2017
*/

@RestController
public class PaymentRequestController {
//PUT request for initiating payment
    @PutMapping("/pmtAddRq")
    public PmtAddRq paymentAddRequest(@RequestBody PmtAddRqInput pmtAddRqInput) {

        //Objects required to build the IFX compliant response
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

        //Code to access the PNC API Exchange to retrieve details based on Card Number
        String url = "http://azureapimanager.pncapix.com:8280/SmartBankAPIServices/V2.0/card/findByCardNumber/{cardNumber}";
        //Map to store the Parameters that are to be passed
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("cardNumber", pmtAddRqInput.getCardEmbossNum());

        //Map to store the headers required for the API Access
        MultiValueMap<String, Object> headers = new LinkedMultiValueMap<>();
        headers.add("Accept", "application/json");
        headers.add("Authorization", "Bearer abd3e694-8f10-3f8a-9cec-90ea0e3bc96e");
        HttpEntity httpEntity = new HttpEntity(headers);

        // Sending the request to the PNC API Exchange
        ResponseEntity<CardResponse[]> cardResponseEntity =
                restTemplate.exchange(url, HttpMethod.GET, httpEntity, CardResponse[].class, paramMap);

       // Response stored in an object built as per the PNC API Response body JSON Structure
        CardResponse[] cardResponse = cardResponseEntity.getBody();


       // Building the target response structure which is IFX Compliant
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

        //Return the JSON response
        return pmtAddRqResponse;
    }

}
