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
Objective: The Card Balance Request Controller provides the end point for the TPP to get Balance of a Card Account.
           It looks up the PNC API Exchange to fill a few additional fields based on the parameters sent by the TPP.
           An IFX Compliant JSON response is built and echoed back.
Created By: CMU BIAN-PNC Capstone Team
Last Update Date: 4/24/2017
*/


@RestController
public class CardBalanceRequestController {
    //GET request for retrieving balance
    @GetMapping("/cardBalRq/{rqUID}/{cardEmbossNum}/{cardEmbossName}/{expDt}")
    public CardBalInqRs CardAcctBalanceRequest(@PathVariable("rqUID") String rqUID,
                                                @PathVariable("cardEmbossNum") String cardEmbossNum,
                                               @PathVariable("cardEmbossName") String cardEmbossName,
                                               @PathVariable("expDt") String expDt) {

        //Objects required to build the IFX compliant response
        CardBalInqRs cardBalInqRs = new CardBalInqRs();
        CardLogicalData cardLogicalData = new CardLogicalData();
        CardAccount cardAccount = new CardAccount();
        Account account = new Account();
        CurAmt curAmt = new CurAmt();
        AcctBal acctBal = new AcctBal();
        cardLogicalData.setName(cardEmbossName);
        cardLogicalData.setCardEmbossNum(cardEmbossNum);
        cardLogicalData.setExpDt(expDt);
        RestTemplate restTemplate = new RestTemplate();

        //Code to access the PNC API Exchange to retrieve details based on Card Number
        String url = "http://apimanager.pncapix.com:8280/SmartBank-API-Services/V2.0/card/findByCardNumber/{cardNumber}";
        //Map to store the Parameters that are to be passed
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("cardNumber", cardEmbossNum);

        //Map to store the headers required for the API Access
        MultiValueMap<String, Object> headers = new LinkedMultiValueMap<>();
        headers.add("Accept", "application/json");
        headers.add("Authorization", "Bearer 16cd1907-6dfd-33ab-b196-9d8419333f3d");
        HttpEntity httpEntity = new HttpEntity(headers);

        // Sending the request to the PNC API Exchange
        ResponseEntity<CardResponse[]> cardResponseEntity =
                restTemplate.exchange(url, HttpMethod.GET, httpEntity, CardResponse[].class, paramMap);

        // Response stored in an object built as per the PNC API Response body JSON Structure
        CardResponse[] cardResponse = cardResponseEntity.getBody();
        cardLogicalData.setBrand(cardResponse[0].getGateway());

        // Building the target response structure which is IFX Compliant
        cardAccount.setCardLogicalData(cardLogicalData);
        cardAccount.setAcctType("Credit");
        cardBalInqRs.setCardAccount(cardAccount);
        cardBalInqRs.setRqUID(rqUID);
        account = cardResponse[0].getAccount();
        curAmt.setAmt(account.getBalance());
        curAmt.setCurCode("USD");
        acctBal.setCurAmt(curAmt);
        acctBal.setBalType("CreditHeld");
        cardBalInqRs.setBalance(acctBal);

        //Return the JSON response
        return(cardBalInqRs);
    }

}
