package tz.co.pesapal.interview.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import tz.co.pesapal.interview.utils.GeneralResponse;

/**
 * @project interview
 * @Author frances on 17/06/2021
 * For Softnet Technologies Limited
 * +255745470673
 */
@ControllerAdvice
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler {

    @Autowired
    private GeneralResponse generalResponse;

    @ExceptionHandler({ BadCredentialsException.class, Exception.class })
    @ResponseBody
    protected GeneralResponse exceptionHandler(Exception exception){
        generalResponse.setMessage("Error occurred please try again later");
        generalResponse.setError(exception.getMessage());

        return generalResponse; 
    }


}
