package edu.cmu.bian.controller;

import edu.cmu.bian.model.Account;
import edu.cmu.bian.model.Party;
import edu.cmu.bian.model.PartyResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;


@RestController
public class AccountController {

    @GetMapping("/hello/{name}")
    public String helloWorld(@PathVariable("name") String name) {
        return "Hello to " + name;
    }

    @GetMapping("/account")
    public Account getAccount() {
        return new Account(15);
    }

    @PostMapping("/account/echo")
    public Account echoAccount(@RequestBody Account account) {
        return account;
    }

    @GetMapping("/party/{lastName}")
    public PartyResponse getParty(@PathVariable String lastName) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://52.14.112.17:8098/api-services-prod/party/person/findByLastName/{lName}?page=0&size=1";

        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("lName", lastName);
/*
        Map<String, Object> headers = new HashMap<>();
        headers.put("auth", "value");
        HttpEntity httpEntity = new HttpEntity(headers);

        ResponseEntity<PartyResponse> partyResponseEntity =
                restTemplate.exchange(url, HttpMethod.GET, httpEntity, PartyResponse.class, paramMap);
        PartyResponse partyResponse = partyResponseEntity.getBody();
  */

        PartyResponse partyResponse = restTemplate.getForObject(url, PartyResponse.class, paramMap);
        System.out.println("party response:" + partyResponse);

        long partyId = partyResponse.getContent().get(0).getPartyId();
        System.out.println("Party ID: " + partyId);
        return partyResponse;
    }
}
