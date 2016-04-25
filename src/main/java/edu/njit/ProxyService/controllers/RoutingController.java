package edu.njit.ProxyService.controllers;

import edu.njit.ProxyService.models.LiveUsers;
import edu.njit.ProxyService.models.ServiceRequest;
import edu.njit.ProxyService.models.StringResponse;
import edu.njit.ProxyService.repository.LiveUserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * Created by srinivaz on 4/24/16.
 */

@org.springframework.web.bind.annotation.RestController

public class RoutingController {


    @Autowired
    LiveUserRepository liveUserRepository;



    @RequestMapping(value="/postRequest", method=RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public LiveUsers proxyServe(@RequestBody ServiceRequest serviceRequest) {


        if(serviceRequest.getServiceType().equalsIgnoreCase(serviceRequest.REQUIRE_SERVICE)) {
            LiveUsers liveUsers = new LiveUsers();
            liveUsers.setUserId(serviceRequest.getUserId());
            liveUsers.setLiveNow(true);
            liveUsers.setServiceType(liveUsers.REQUIRE_SERVICE);
            liveUserRepository.insert(liveUsers);
            return liveUsers;
        }

        else if(serviceRequest.getServiceType().equalsIgnoreCase(ServiceRequest.PROVIDE_SERVICE) ) {

            LiveUsers liveUsers = new LiveUsers();
            liveUsers.setUserId(serviceRequest.getUserId());
            liveUsers.setServiceType(serviceRequest.getServiceType());
            liveUsers.setLiveNow(true);

        }


return null;
    }

    @RequestMapping(value = "/initialize" ,method=RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public String initializeUserConf() {



        return String.valueOf(UUID.randomUUID());


    }

    @RequestMapping(value = "/disconnect",method = RequestMethod.POST)
    public void disconnectUser() {



    }

}
