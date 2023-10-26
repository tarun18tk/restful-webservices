package com.springboot.rest.webservices.restfulwebservices.helloworld;

public class HelloWorldBean {
    private String s;

    HelloWorldBean(String s) {
        this.s = s;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    @Override
    public String toString() {
        return "HelloWorldBean [s=" + s + "]";
    }

}