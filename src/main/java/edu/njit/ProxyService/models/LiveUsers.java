package edu.njit.ProxyService.models;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.lang.annotation.Documented;


/**
 * Created by srinivaz on 4/24/16.
 */

@Document(collection = "live_users")
public class LiveUsers {

    public final static String REQUIRE_SERVICE = "require_proxy_service";

    public final  static  String PROVIDE_SERVICE = "provide_proxy_service";

    @Id
    private String userId;

    private boolean liveNow;

    private String serviceType;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public boolean isLiveNow() {
        return liveNow;
    }

    public void setLiveNow(boolean liveNow) {
        this.liveNow = liveNow;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }


    public String toString() {

return "userid="+userId+"servicetype="+serviceType+"livenow="+liveNow;

    }
}
