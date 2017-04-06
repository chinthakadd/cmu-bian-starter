package edu.cmu.bian.controller;

import edu.cmu.bian.model.PaymentModel;
import org.springframework.web.bind.annotation.*;


@RestController
public class Dev_3_Controller {

    @PostMapping("/dev3/hello2/{name}")
    public String helloWorld(@PathVariable("name") String name, @RequestParam("size") int height, @RequestBody PaymentModel paymentModel, @RequestHeader("someHeader") int someHeader) {
        return "this is the path param " + name + " and this is a query param " + height + " " + paymentModel.getPayeeAccountNumber() + " " + someHeader ;
    }
}
