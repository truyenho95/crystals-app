package com.truyenhln.crystals.configurations;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.springframework.security.config.Customizer.withDefaults;

@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
public class CrystalsSecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.inMemoryAuthentication().passwordEncoder(passwordEncoder)
                                    .withUser("justin").password(passwordEncoder.encode("tyh"))
                                    .roles("ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.requestMatchers((requestMatchers) ->
                                     requestMatchers
                                             .antMatchers("/api/**", "/oauth/**", "/greeting"))
            .authorizeRequests((authorizeRequests) ->
                                       authorizeRequests
                                               .antMatchers("/**").hasRole("ADMIN")
            )
            .httpBasic(withDefaults());
    }
}
