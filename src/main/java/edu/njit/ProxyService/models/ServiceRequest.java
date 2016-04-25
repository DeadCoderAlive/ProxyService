package edu.njit.ProxyService.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;

/**
 * Created by srinivaz on 4/24/16.
 */
@Component
public class ServiceRequest {

    public final static String REQUIRE_SERVICE = "require_proxy_service";

    public final  static  String PROVIDE_SERVICE = "provide_proxy_service";


    private String UserId;

    private String serviceType;

    private String urlRequested;


    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }


    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getUrlRequested() {
        return urlRequested;
    }

    public void setUrlRequested(String urlRequested) {
        this.urlRequested = urlRequested;
    }
}
