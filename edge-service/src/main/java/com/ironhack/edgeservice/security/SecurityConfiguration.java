package com.ironhack.edgeservice.security;

import com.ironhack.edgeservice.client.UserClient;
import com.ironhack.edgeservice.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled=true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserClient userClient;

    @Autowired
    EntryPoint entryPoint;

    @Autowired
    UserDetailsServiceImpl userDetailsServiceImpl;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsServiceImpl)
                .passwordEncoder(passwordEncoder);
    }

    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.httpBasic().authenticationEntryPoint(entryPoint);

        httpSecurity.csrf().disable();
        httpSecurity.authorizeRequests().antMatchers("/").permitAll().and().authorizeRequests().antMatchers("/h2-console/**").permitAll();

        httpSecurity.headers().frameOptions().disable();

        httpSecurity.authorizeRequests()
                /*.mvcMatchers(HttpMethod.GET, "/lead/find_by/{id}").hasAnyAuthority("ROLE_SALESPERSON")
                .mvcMatchers(HttpMethod.POST, "/lead/save").hasAnyAuthority("ROLE_SALESPERSON")
                .mvcMatchers(HttpMethod.GET, "/leads").hasAnyAuthority("ROLE_SALESPERSON")
                .mvcMatchers(HttpMethod.DELETE, "/lead/delete/{id}").hasAnyAuthority("ROLE_SALESPERSON")
                .mvcMatchers(HttpMethod.POST, "/contact/save").hasAnyAuthority("ROLE_SALESPERSON")
                .mvcMatchers(HttpMethod.GET, "/contacts").hasAnyAuthority("ROLE_SALESPERSON")
                .mvcMatchers(HttpMethod.GET, "/contact/find_by/{product}").hasAnyAuthority("ROLE_SALESPERSON")
                .mvcMatchers(HttpMethod.POST, "/account/new").hasAnyAuthority("ROLE_SALESPERSON")
                .mvcMatchers(HttpMethod.GET, "/account/{id}").hasAnyAuthority("ROLE_SALESPERSON")
                .mvcMatchers(HttpMethod.GET, "/accounts").hasAnyAuthority("ROLE_SALESPERSON")
                .mvcMatchers(HttpMethod.GET, "/accounts/statistics/**").hasAnyAuthority("ROLE_SALESPERSON")
                .mvcMatchers(HttpMethod.POST, "/opportunity/new").hasAnyAuthority("ROLE_SALESPERSON")
                .mvcMatchers(HttpMethod.GET, "/opportunity/{id}").hasAnyAuthority("ROLE_SALESPERSON")
                .mvcMatchers(HttpMethod.GET, "/opportunities**").hasAnyAuthority("ROLE_SALESPERSON")
                .mvcMatchers(HttpMethod.POST, "/salesrep/save/**").hasAuthority("ROLE_ADMIN")
                .mvcMatchers(HttpMethod.GET, "/salerep/find_by_id/{id}").hasAuthority("ROLE_ADMIN")
                .mvcMatchers(HttpMethod.GET, "/salesreps").hasAuthority("ROLE_ADMIN")
                .mvcMatchers(HttpMethod.GET, "/leads/find_by_salesrep").hasAuthority("ROLE_ADMIN")
                .mvcMatchers(HttpMethod.GET, "/lead/convert**").hasAuthority("ROLE_ADMIN")

                 */
                .anyRequest().permitAll();

    }
}
