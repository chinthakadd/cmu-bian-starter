package edu.cmu.bian.model;

/**
 * Created by chaitanyakvk on 3/27/2017.
 */
public class CompositeObject {

    private ChildObject child;

    private String name;

    public CompositeObject(){

    }

    public CompositeObject(ChildObject child, String name){
        this.child = child;
        this.name = name;
    }

    public ChildObject getChild() {
        return child;
    }

    public void setChild(ChildObject child) {
        this.child = child;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
