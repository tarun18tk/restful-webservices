package com.springboot.rest.webservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {

    // The best and simple was from URIs
    // Factors to decide notes below

    @GetMapping("v1/person")
    public PersonV1 getFirstVersionOfPerson() {
        return new PersonV1("Bob Charlie");
    }

    @GetMapping("v2/person")
    public PersonV2 getSecondVersionOfPerson() {
        return new PersonV2("Bob", "Charlie");
    }

    @GetMapping(path = "/person", params = "version=1")
    public PersonV1 getFirstVersionOfPersonRequestParam() {
        return new PersonV1("BobCharlie");
    }

    @GetMapping(path = "/person", params = "version=2")
    public PersonV2 getSecondVersionOfPersonRequestParam() {
        return new PersonV2("Bob", "Charlie");
    }

    // this was implemented in some chrome extension where we can select the headers
    // that goes with the URL
    @GetMapping(path = "/person/header", headers = "X-API-VERSION=1")
    public PersonV1 getFirstVersionOfPersonRequstHeader() {
        return new PersonV1("BobCharlie");
    }

    // this is also in the extension
    @GetMapping(path = "/person/accept", produces = "application/vnd.company.app-v1+json")
    public PersonV1 getFirstPersonAcceptHeader() {
        return new PersonV1("Tarun Karki");
    }

    /*
     * Factors to consider
     * 1. URI Pollution
     * 2. Misuse of HTTP headers
     * 3. Caching
     * 4. Can we execute the request on browsers
     * 5. API Documentation
     */

    /*
     * Think about versioning before we need it
     * One Enterprise - one different approach
     */

}
