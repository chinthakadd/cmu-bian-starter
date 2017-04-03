package edu.cmu.bian.model;

/**
 * Created by chaitanyakvk on 3/27/2017.
 */
public class ChildObject {

    private String name;

    public ChildObject() {

    }

    public ChildObject(String name) {

        this.name = name+name;
    }


    public String getName() {
        return name+name;
    }

    public void setName(String name) {
        this.name = name+name;
    }
}
