package com.Decathlon.pojo;

public class BugTraker {

    private boolean isTrue = false;

    public BugTraker(){}

    public void setStatus(Boolean state){this.isTrue =state;}

    public void printResults(){
        String isPass = isTrue ? "":"";
    }
}
