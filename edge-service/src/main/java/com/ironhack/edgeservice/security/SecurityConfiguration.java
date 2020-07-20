package com.ironhack.edgeservice.security;

import com.ironhack.edgeservice.util.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.savedrequest.NullRequestCache;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserService userService;

    @Bean
    public PasswordEncoder passwordEncoder () {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userService)
                .passwordEncoder(passwordEncoder);
    }

    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception {
        /*
        httpSecurity.httpBasic();
        httpSecurity.authorizeRequests().anyRequest().permitAll();
        httpSecurity.csrf().disable();
        httpSecurity.formLogin()
                .permitAll()
                .loginPage("/login");
        httpSecurity.logout()
                .permitAll()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/logout/success")
                .deleteCookies("auth_code", "JSESSIONID")
                .clearAuthentication(true)
                .invalidateHttpSession(true);
         */

        httpSecurity.httpBasic();

        httpSecurity.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().authorizeRequests()
                // --- SALESREP CONTROLLER SECURITY ---
                // region --- BASIC QUERYS ---
                .mvcMatchers("/SalesReps").hasAuthority("ROLE_SALESREP")
                .mvcMatchers("/SalesRep/byId").hasAuthority("ROLE_SALESREP")
                .mvcMatchers(HttpMethod.POST,"/SalesRep/Create").hasAuthority("ROLE_ADMIN")
                .mvcMatchers(HttpMethod.PUT,"/SalesRep/Update").hasAuthority("ROLE_ADMIN")
                .mvcMatchers(HttpMethod.PATCH,"/SalesRep/UpdateName").hasAuthority("ROLE_ADMIN")
                .mvcMatchers(HttpMethod.DELETE,"/SalesRep/Delete").hasAuthority("ROLE_ADMIN")
                // endregion

                // region Routes findBy
                .mvcMatchers("/SalesRep/byName").hasAuthority("ROLE_SALESREP")
                .mvcMatchers("/SalesRep/byPhoneNumber").hasAuthority("ROLE_SALESREP")
                .mvcMatchers("/SalesRep/byEmail").hasAuthority("ROLE_SALESREP")
                // endregion


                // --- CONTACT CONTROLLER SECURITY ---
                // region --- BASIC QUERYS ---
                .mvcMatchers("/contacts").hasAuthority("ROLE_SALESREP")
                .mvcMatchers("/contact").hasAuthority("ROLE_SALESREP")
                .mvcMatchers("/contact/byInformationContactName").hasAuthority("ROLE_SALESREP")
                .mvcMatchers("/contact/byInformationContactPhone").hasAuthority("ROLE_SALESREP")
                .mvcMatchers("/contact/byInformationContactEmail").hasAuthority("ROLE_SALESREP")
                .mvcMatchers(HttpMethod.POST,"/contact").hasAuthority("ROLE_SALESREP")
                .mvcMatchers(HttpMethod.PUT,"/contact/update/{idRequest}").hasAuthority("ROLE_SALESREP")
                .mvcMatchers(HttpMethod.PATCH,"/contact/update/{idRequest}").hasAuthority("ROLE_SALESREP")
                .mvcMatchers(HttpMethod.PATCH,"/contact/update/name/{idRequest}").hasAuthority("ROLE_SALESREP")
                .mvcMatchers(HttpMethod.PATCH,"/contact/update/phone/{idRequest}").hasAuthority("ROLE_SALESREP")
                .mvcMatchers(HttpMethod.PATCH,"/contact/update/email/{idRequest}").hasAuthority("ROLE_SALESREP")
                .mvcMatchers(HttpMethod.DELETE,"/contact").hasAuthority("ROLE_SALESREP")
                // endregion


                // --- LEAD CONTROLLER SECURITY ---
                // region --- BASIC QUERYS ---
                .mvcMatchers("/leads").hasAuthority("ROLE_SALESREP")
                .mvcMatchers("/lead/id/{id}").hasAuthority("ROLE_SALESREP")
                .mvcMatchers("/lead/phone/{phoneNumber}").hasAuthority("ROLE_SALESREP")
                .mvcMatchers("/lead/name/{name}").hasAuthority("ROLE_SALESREP")
                .mvcMatchers("/lead/email/{email}").hasAuthority("ROLE_SALESREP")
                .mvcMatchers("/lead/company/{company}").hasAuthority("ROLE_SALESREP")
                .mvcMatchers(HttpMethod.POST,"/lead").hasAuthority("ROLE_SALESREP")
                .mvcMatchers(HttpMethod.PUT,"/lead/{id}").hasAuthority("ROLE_SALESREP")
                .mvcMatchers(HttpMethod.DELETE,"/lead/{id}").hasAuthority("ROLE_SALESREP")
                .mvcMatchers(HttpMethod.DELETE,"/leads/delete").hasAuthority("ROLE_SALESREP")
                .mvcMatchers(HttpMethod.PUT,"/lead/convert/existing_account/{leadId}").hasAnyAuthority("ROLE_ADMIN","ROLE_SALESREP")
                .mvcMatchers(HttpMethod.PUT,"/lead/convert/new_account/{leadId}").hasAnyAuthority("ROLE_ADMIN","ROLE_SALESREP")
                // endregion


                // --- ACCOUNT CONTROLLER SECURITY ---
                // region --- BASIC QUERYS ---
                .mvcMatchers("/accounts").hasAuthority("ROLE_SALESREP")
                .mvcMatchers("/account/byId").hasAuthority("ROLE_SALESREP")
                .mvcMatchers(HttpMethod.PUT,"/account/update").hasAuthority("ROLE_SALESREP")
                .mvcMatchers(HttpMethod.PATCH,"/account/updateUbication").hasAuthority("ROLE_SALESREP")
                .mvcMatchers(HttpMethod.DELETE,"/account/delete").hasAuthority("ROLE_SALESREP")
                // endregion

                // region Routes findBy
                .mvcMatchers("/account/byIndustry").hasAuthority("ROLE_SALESREP")
                .mvcMatchers("/account/byEmployeeCount").hasAuthority("ROLE_SALESREP")
                .mvcMatchers("/account/byCity").hasAuthority("ROLE_SALESREP")
                .mvcMatchers("/account/byCountry").hasAuthority("ROLE_SALESREP")
                // endregion

                // region Routes Reports EmployeeCount States
                .mvcMatchers("/account/meanEmployeeCount").hasAuthority("ROLE_SALESREP")
                .mvcMatchers("/account/maxEmployeeCount").hasAuthority("ROLE_SALESREP")
                .mvcMatchers("/account/minEmployeeCount").hasAuthority("ROLE_SALESREP")
                .mvcMatchers("/account/medianEmployeeCount").hasAuthority("ROLE_SALESREP")
                // endregion


                // --- OPPORTUNITY CONTROLLER SECURITY ---
                // region --- BASIC QUERYS ---
                .mvcMatchers("/opportunities").hasAuthority("ROLE_SALESREP")
                .mvcMatchers("/opportunities/by_product").hasAuthority("ROLE_SALESREP")
                .mvcMatchers("/opportunities/by_quantity").hasAuthority("ROLE_SALESREP")
                .mvcMatchers("/opportunities/by_status").hasAuthority("ROLE_SALESREP")
                .mvcMatchers(HttpMethod.PATCH, "/opportunity/change_status").hasAuthority("ROLE_SALESREP")
                .mvcMatchers(HttpMethod.PATCH,"/opportunity/change_quantity").hasAuthority("ROLE_SALESREP")
                .mvcMatchers(HttpMethod.DELETE, "/opportunity").hasAuthority("ROLE_SALESREP")
                // endregion

                // region --- BY SALESREP ---
                .mvcMatchers("/opportunities/by_salesrep/count_lead").hasAuthority("ROLE_SALESREP")
                .mvcMatchers("/opportunities/by_salesrep/count_opportunity").hasAuthority("ROLE_SALESREP")
                .mvcMatchers("/opportunities/by_salesrep/count_closed_won_opportunity").hasAuthority("ROLE_SALESREP")
                .mvcMatchers("/opportunities/by_salesrep/count_closed_lost_opportunity").hasAuthority("ROLE_SALESREP")
                .mvcMatchers("/opportunities/by_salesrep/count_open_opportunity").hasAuthority("ROLE_SALESREP")
                // endregion

                // region --- BY PRODUCT ---
                .mvcMatchers("/opportunities/by_product/count_lead").hasAuthority("ROLE_SALESREP")
                .mvcMatchers("/opportunities/by_product/count_opportunity").hasAuthority("ROLE_SALESREP")
                .mvcMatchers("/opportunities/by_product/count_closed_won_opportunity").hasAuthority("ROLE_SALESREP")
                .mvcMatchers("/opportunities/by_product/count_closed_lost_opportunity").hasAuthority("ROLE_SALESREP")
                .mvcMatchers("/opportunities/by_product/count_open_opportunity").hasAuthority("ROLE_SALESREP")
                // endregion

                // region --- BY COUNTRY ---
                .mvcMatchers("/opportunities/by_country/count_lead").hasAuthority("ROLE_SALESREP")
                .mvcMatchers("/opportunities/by_country/count_opportunity").hasAuthority("ROLE_SALESREP")
                .mvcMatchers("/opportunities/by_country/count_closed_won_opportunity").hasAuthority("ROLE_SALESREP")
                .mvcMatchers("/opportunities/by_country/count_closed_lost_opportunity").hasAuthority("ROLE_SALESREP")
                .mvcMatchers("/opportunities/by_country/count_open_opportunity").hasAuthority("ROLE_SALESREP")
                // endregion

                // region --- BY CITY ---
                .mvcMatchers("/opportunities/by_city/count_lead").hasAuthority("ROLE_SALESREP")
                .mvcMatchers("/opportunities/by_city/count_opportunity").hasAuthority("ROLE_SALESREP")
                .mvcMatchers("/opportunities/by_city/count_closed_won_opportunity").hasAuthority("ROLE_SALESREP")
                .mvcMatchers("/opportunities/by_city/count_closed_lost_opportunity").hasAuthority("ROLE_SALESREP")
                .mvcMatchers("/opportunities/by_city/count_open_opportunity").hasAuthority("ROLE_SALESREP")
                // endregion

                // region --- BY INDUSTRY ---
                .mvcMatchers("/opportunities/by_industry/count_lead").hasAuthority("ROLE_SALESREP")
                .mvcMatchers("/opportunities/by_industry/count_opportunity").hasAuthority("ROLE_SALESREP")
                .mvcMatchers("/opportunities/by_industry/count_closed_won_opportunity").hasAuthority("ROLE_SALESREP")
                .mvcMatchers("/opportunities/by_industry/count_closed_lost_opportunity").hasAuthority("ROLE_SALESREP")
                .mvcMatchers("/opportunities/by_industry/count_open_opportunity").hasAuthority("ROLE_SALESREP")
                // endregion

                // region --- QUANTITY STATES ---
                .mvcMatchers("/opportunities/by_quantity/mean").hasAuthority("ROLE_SALESREP")
                .mvcMatchers("/opportunities/by_quantity/median").hasAuthority("ROLE_SALESREP")
                .mvcMatchers("/opportunities/by_quantity/max").hasAuthority("ROLE_SALESREP")
                .mvcMatchers("/opportunities/by_quantity/min").hasAuthority("ROLE_SALESREP")
                // endregion

                // region --- OPPORTUNITY STATES ---
                .mvcMatchers("/opportunities/by_opportunity_states/mean").hasAuthority("ROLE_SALESREP")
                .mvcMatchers("/opportunities/by_opportunity_states/median").hasAuthority("ROLE_SALESREP")
                .mvcMatchers("/opportunities/by_opportunity_states/max").hasAuthority("ROLE_SALESREP")
                .mvcMatchers("/opportunities/by_opportunity_states/min").hasAuthority("ROLE_SALESREP")
                // endregion

                .and().requestCache().requestCache(new NullRequestCache()).and().httpBasic().and().cors().and().csrf().disable();


    }

}