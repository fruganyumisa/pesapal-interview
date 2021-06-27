package tz.co.pesapal.interview.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import tz.co.pesapal.interview.security.AdminAuthFilter;
import tz.co.pesapal.interview.security.AdminUsernamePasswordAuthProvider;
import tz.co.pesapal.interview.security.CustomAuthenticationFailureHandler;
import tz.co.pesapal.interview.security.JwtTokenFilter;

/**
 * @project interview
 * @Author frances on 16/06/2021
 * For Softnet Technologies Limited
 * +255745470673
 */

@Configuration
public class AppConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private AdminUsernamePasswordAuthProvider adminAuthProvider;

    @Autowired
    private AdminAuthFilter adminAuthFilter;

    @Autowired
    private JwtTokenFilter jwtTokenFilter;

    @Autowired
    CustomAuthenticationFailureHandler authenticationFailureHandler;

    @Bean
    public PasswordEncoder passwordEncoder(){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth){
        auth.authenticationProvider(adminAuthProvider);

    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
            .httpBasic().disable()
            .cors().and()
            .exceptionHandling()
            .authenticationEntryPoint(authenticationFailureHandler)
            .and()
            .authorizeRequests()
            .antMatchers("/donate").permitAll()
            .antMatchers("/privacy").permitAll()
            .anyRequest().authenticated()
            .and().sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource(){
        CorsConfiguration corsConfiguration = new CorsConfiguration().applyPermitDefaultValues();
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfiguration);
        return source;
    }
}
