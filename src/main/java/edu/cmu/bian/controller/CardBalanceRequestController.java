package edu.cmu.bian.controller;

import edu.cmu.bian.model.PmtAddRq.*;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import java.util.HashMap;
import java.util.Map;


@RestController
public class CardBalanceRequestController {

    @GetMapping("/cardBalRq/{rqUID}/{cardEmbossNum}/{cardEmbossName}/{expDt}")
    public CardBalInqRs CardAcctBalanceRequest(@PathVariable("rqUID") String rqUID,
                                                @PathVariable("cardEmbossNum") String cardEmbossNum,
                                               @PathVariable("cardEmbossName") String cardEmbossName,
                                               @PathVariable("expDt") String expDt) {

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
        String url = "http://apimanager.pncapix.com:8280/SmartBank-API-Services/V2.0/card/findByCardNumber/{cardNumber}";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("cardNumber", cardEmbossNum);
        MultiValueMap<String, Object> headers = new LinkedMultiValueMap<>();
        headers.add("Accept", "application/json");
        headers.add("Authorization", "Bearer 16cd1907-6dfd-33ab-b196-9d8419333f3d");
        HttpEntity httpEntity = new HttpEntity(headers);
        ResponseEntity<CardResponse[]> cardResponseEntity =
                restTemplate.exchange(url, HttpMethod.GET, httpEntity, CardResponse[].class, paramMap);
        CardResponse[] cardResponse = cardResponseEntity.getBody();
        cardLogicalData.setBrand(cardResponse[0].getGateway());


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
        return(cardBalInqRs);
    }

}
