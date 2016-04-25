package edu.njit.ProxyService.controllers;

import edu.njit.ProxyService.models.*;
import edu.njit.ProxyService.repository.CachedWebPagesRepository;
import edu.njit.ProxyService.repository.LiveUserRepository;

import edu.njit.ProxyService.repository.ProxyNeedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by srinivaz on 4/24/16.
 */

@org.springframework.web.bind.annotation.RestController

public class RoutingController {


    @Autowired
    LiveUserRepository liveUserRepository;

    @Autowired
    ProxyNeedRepository proxyNeedRepository;

    @Autowired
    CachedWebPagesRepository cachedWebPagesRepository;



    @RequestMapping(value="/postRequest", method=RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public LiveUsers proxyServe(@RequestBody ServiceRequest serviceRequest) {

        System.out.println(serviceRequest.getServiceType());
        if(serviceRequest.getServiceType().equalsIgnoreCase(serviceRequest.REQUIRE_SERVICE)) {
            LiveUsers liveUsers = new LiveUsers();
            liveUsers.setUserId(serviceRequest.getUserId());
            liveUsers.setLiveNow(true);
            liveUsers.setServiceType(liveUsers.REQUIRE_SERVICE);
            liveUserRepository.insert(liveUsers);
            ProxyNeed proxyNeed = new ProxyNeed();
            proxyNeed.setUserId(serviceRequest.getUserId());
            proxyNeed.setNeed(true);
            proxyNeed.setUrl(serviceRequest.getUrlRequested());
            proxyNeedRepository.insert(proxyNeed);
            return liveUsers;
        }

        else if(serviceRequest.getServiceType().equalsIgnoreCase(ServiceRequest.PROVIDE_SERVICE) ) {

            LiveUsers liveUsers = new LiveUsers();
            liveUsers.setUserId(serviceRequest.getUserId());
            liveUsers.setServiceType(serviceRequest.getServiceType());
            liveUsers.setLiveNow(true);
            return liveUsers;

        }


return null;
    }

    @RequestMapping(value = "/initialize" ,method=RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public User initializeUserConf() {

        User user = new User();
         user.setUserId(String.valueOf(UUID.randomUUID()));

        return user;


    }

    @RequestMapping(value = "/disconnect/{userId}",method = RequestMethod.POST)
    public void disconnectUser(@PathVariable String userId) {
        liveUserRepository.delete(userId);
        LiveUsers liveUsers = new LiveUsers();
        liveUsers.setLiveNow(false);
        liveUsers.setUserId(userId);
        liveUserRepository.insert(liveUsers);

    }

    @RequestMapping(value = "/getWebPage/{userId}",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public String getWebPageBody(@PathVariable String userId) {
        CachedWebPages cachedWebPages = cachedWebPagesRepository.findOne(userId);
        if(cachedWebPages.getHtmlBody().isEmpty()) {


            return null;



        }

        else {

            return cachedWebPages.getHtmlBody();


        }




    }
    @RequestMapping(value = "/provideProxy",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ProxyNeed getProxyNeed() {

        List<ProxyNeed> proxyNeeds = new ArrayList<ProxyNeed>();

        if (!proxyNeeds.isEmpty()) {

            ProxyNeed proxyNeed = proxyNeeds.get(0);

            return proxyNeed;

        } else {

            return null;
        }
    }

    @RequestMapping(value = "/provideWebPage",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
       public void provideWebPage(@RequestBody CachedWebPages cachedWebPages) {


        String userId = cachedWebPages.getRequesterUserId();
        cachedWebPagesRepository.delete(userId);
        cachedWebPagesRepository.insert(cachedWebPages);


    }


}
