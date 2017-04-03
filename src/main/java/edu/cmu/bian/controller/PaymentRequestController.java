package edu.cmu.bian.controller;

import edu.cmu.bian.model.Account;
import edu.cmu.bian.model.CompositeObject;
import edu.cmu.bian.model.PartyResponse;
import edu.cmu.bian.model.PaymentModel;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.HttpsURLConnection;
import java.util.HashMap;
import java.util.Map;


@RestController
public class PaymentController {

    @PostMapping("/hello2/{name}")
    public String helloWorld(@PathVariable("name") String name, @RequestParam("size") int height, @RequestBody PaymentModel paymentModel, @RequestHeader("someHeader") int someHeader) {
        return "this is the path param " + name + " and this is a query param " + height + " " + paymentModel.getPayeeAccountNumber() + " " + someHeader ;
    }

    @PostMapping("/hello3/{name}")
    public PaymentModel helloWorld2(@PathVariable("name") String name, @RequestParam("size") int height, @RequestBody PaymentModel paymentModel, @RequestHeader("someHeader") int someHeader) {
        return paymentModel;
    }

    @PostMapping("/hello4/{name}")
    public CompositeObject helloWorld3(@PathVariable("name") String name, @RequestParam("size") int height, @RequestBody CompositeObject compositeObject, @RequestHeader("someHeader") int someHeader) {
        return compositeObject;
    }


    @GetMapping("/card/{cardNumber}")
    public String getCardData(@PathVariable String cardNumber) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://apimanager.pncapix.com:8280/smartbank-card/1.0.0/1.0.0/card/{cardNumber}";
 //    HttpsURLConnection.setDefaultHostnameVerifier ((hostname, session) -> true);
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("cardNumber", 1);

        MultiValueMap<String, Object> headers = new LinkedMultiValueMap<>();

        headers.add("Accept", "application/json");
        headers.add("Authorization", "Bearer ce0fe2cf-2dc0-3e96-b489-5806070265a0");
//        headers.put("cache-control", "no-cache");
//        headers.put("postman-token", "1b31b01a-9c73-4d47-092b-9940c9e0da98");

        HttpEntity httpEntity = new HttpEntity(headers);

        ResponseEntity<String> partyResponseEntity =
                restTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class, paramMap);
        String partyResponse = partyResponseEntity.getBody();



//        PartyResponse partyResponse = restTemplate.getForObject(url, PartyResponse.class, paramMap);
//        System.out.println("party response:" + partyResponse);
//
//        long partyId = partyResponse.getContent().get(0).getPartyId();
//        System.out.println("Party ID: " + partyId);

        System.out.println("partyResponse: " + partyResponse);
        return partyResponse;
    }
}
