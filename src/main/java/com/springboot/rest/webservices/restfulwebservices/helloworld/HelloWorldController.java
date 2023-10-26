package com.springboot.rest.webservices.restfulwebservices.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

//REST API
@RestController
public class HelloWorldController {

    // if this url is called /hello-world
    // then a string as "Hello World" is given back
    // @RequestMapping(value = "hello-world", method = RequestMethod.GET)
    // public String helloWorld() {
    // return "hello-world";
    // }
    // new way
    @GetMapping(path = "/hello-world")
    public String helloWorld() {
        return "hello-world-from-new-annotation";
    }

    // this here is returning a bean and our springboot converts this into json
    @GetMapping(value = "/hello-world-bean")
    public HelloWorldBean helloWorldBean() {
        return new HelloWorldBean("Welcome to Hello World");
    }

    // to manage variables of a URL we use @PathVarialbe annotation
    @GetMapping(value = "/hello-world-bean/{name}")
    public HelloWorldBean helloWorldBeanPath(@PathVariable String name) {
        return new HelloWorldBean("Welcome to Hello World " + name);
    }

    /*
     * When we are sending details from (resource here ->)URL we are using Get
     * Request Method
     */
    /* If i want to create a new resource(i.e. data on a URL) we make POST method */
    /* If we wish to modify resources we make use of PUT method */

}
