package edu.cmu.bian.model.PmtAddRq;


/*
Objective: This is an Account model class which would be used to create composite objects that are necessary
           for creating appropriate response message structures as per IFX.
           The class and variable names are consistent with the IFX naming conventions.
Created By: CMU BIAN-PNC Capstone Team
Last Update Date: 4/24/2017
*/

public class HelloResponse {

    private String message;

    public HelloResponse() {
    }

    public HelloResponse(String message) {
        this.message = message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }

}

