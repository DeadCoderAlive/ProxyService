package edu.njit.ProxyService.controllers;

import edu.njit.ProxyService.models.StringResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by srinivaz on 4/24/16.
 */

@RestController

public class RoutingController {


    @Autowired
    StringResponse stringResponse;

    @RequestMapping(value="/", method= RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public StringResponse getResponse() {


        stringResponse.setResponse("omala");

        return stringResponse;

    }


}
