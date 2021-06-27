package tz.co.pesapal.interview.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * @project interview
 * @Author frances on 16/06/2021
 * For Softnet Technologies Limited
 * +255745470673
 */
public class UsernamePasswordAuth extends UsernamePasswordAuthenticationToken {
    public UsernamePasswordAuth(Object principal, Object credentials) {
        super(principal, credentials);
    }

    public UsernamePasswordAuth(Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities) {
        super(principal, credentials, authorities);
    }
}
