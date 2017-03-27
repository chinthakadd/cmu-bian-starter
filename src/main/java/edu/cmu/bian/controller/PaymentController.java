package edu.cmu.bian.controller;

import edu.cmu.bian.model.Account;
import edu.cmu.bian.model.CompositeObject;
import edu.cmu.bian.model.PartyResponse;
import edu.cmu.bian.model.PaymentModel;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

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


}
