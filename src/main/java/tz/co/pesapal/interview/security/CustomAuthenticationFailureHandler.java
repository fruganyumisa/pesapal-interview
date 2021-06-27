package tz.co.pesapal.interview.security;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import tz.co.pesapal.interview.utils.GeneralResponse;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @project interview
 * @Author frances on 17/06/2021
 * For Softnet Technologies Limited
 * +255745470673
 */
@Component
public class CustomAuthenticationFailureHandler implements AuthenticationEntryPoint {
    @Autowired
    GeneralResponse generalResponse;


    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {

        generalResponse.setError("Authentication failed.");
        generalResponse.setMessage(null);

        String json = new Gson().toJson(generalResponse);

        response.setContentType("application/json");
        response.getWriter().write(json);
    }
}
