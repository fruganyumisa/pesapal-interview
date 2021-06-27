package tz.co.pesapal.interview.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import tz.co.pesapal.interview.beans.Admin;
import tz.co.pesapal.interview.services.AdminService;
import tz.co.pesapal.interview.utils.JWTUtil;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @project interview
 * @Author frances on 17/06/2021
 * For Softnet Technologies Limited
 * +255745470673
 */
@Component
public class AdminAuthFilter extends OncePerRequestFilter {


    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    private AdminService adminService;

    //@Autowired
    private AuthenticationManager authenticationManager;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        Admin admin = mapper.readValue(request.getInputStream(), Admin.class);
        Authentication  user = new UsernamePasswordAuth(admin.getUsername(), admin.getPassword());
        user = authenticationManager.authenticate(user);

        //Generate the jwt token

        String token = jwtUtil.generateToken(admin);

        Admin authAdmin = adminService.findAdminByUsername(admin.getUsername());
        response.setHeader("Content-Type", "Application/json");

        Map<String, Object> resMap = new HashMap<String, Object>();
        resMap.put("jwt", token);
        resMap.put("username",admin.getUsername());
        resMap.put("adminId", admin.getId());

        String res = new Gson().toJson(resMap);

    }
}
