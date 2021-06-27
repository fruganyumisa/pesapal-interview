package tz.co.pesapal.interview.utils;

import org.springframework.stereotype.Component;

/**
 * @project interview
 * @Author frances on 17/06/2021
 * For Softnet Technologies Limited
 * +255745470673
 */

@Component
public class GeneralResponse {
    //Response object for simple response with message

    private String message;

    private String error;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }


}

