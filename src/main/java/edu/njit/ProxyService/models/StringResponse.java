package edu.njit.ProxyService.models;

import org.springframework.stereotype.Component;

/**
 * Created by srinivaz on 4/24/16.
 */

@Component
public class StringResponse {

    private String response;

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
