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
public class HelloWorldController {
    //GET request for retrieving balance
    @GetMapping("/helloWorld")
    public String sayHello(){
        //Return the JSON response
        return("hello");
    }

}
