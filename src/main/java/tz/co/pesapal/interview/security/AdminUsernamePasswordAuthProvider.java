package tz.co.pesapal.interview.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import tz.co.pesapal.interview.services.AdminService;

/**
 * @project interview
 * @Author frances on 16/06/2021
 * For Softnet Technologies Limited
 * +255745470673
 */

@Component
public class AdminUsernamePasswordAuthProvider implements AuthenticationProvider {

    @Autowired
    private AdminService adminService;

    //@Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = (String) authentication.getCredentials();

        UserDetails admin = adminService.findAdminByUsername(username);

        if (admin != null && passwordEncoder.matches(password, admin.getPassword())) {

            return new UsernamePasswordAuth(username, password, admin.getAuthorities());
        }

        throw new BadCredentialsException("User Authentication failed.");
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuth.class.equals(authentication);
    }
}
