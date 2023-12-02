package com.example.tsl.config;

import com.example.tsl.exceptions.handler.CustomAccessDeniedHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    private CustomAccessDeniedHandler accessDeniedHandler;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests(authorizeRequests ->
                        authorizeRequests
                                .antMatchers("/h2-console/**").permitAll()
                                .antMatchers("/", "/login-form", "/main-info", "/demo", "/contact", "/img/**", "/style/**").permitAll()
                                .antMatchers("/contact", "/submit-contact", "/contact-confirm").permitAll()
                                .antMatchers("/warehouses/**").hasAnyRole("FORWARDER", "PLANNER", "ADMIN")
                                .antMatchers("/cargos/**").hasAnyRole("FORWARDER", "PLANNER", "ADMIN")
                                .antMatchers("/contractors/**").hasAnyRole("FORWARDER", "PLANNER", "ADMIN")
                                .antMatchers("/orders/**").hasAnyRole("FORWARDER", "PLANNER", "ADMIN")
                                .antMatchers("/invoices/**").hasAnyRole("ACCOUNTANT", "ADMIN")
                                .anyRequest().authenticated()
                )
                .formLogin(login -> login
                        .loginPage("/login").permitAll()
                        .defaultSuccessUrl("/main-page", true)
                        .failureUrl("/login?error=true"))
                .logout(logout -> logout
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                        .logoutSuccessUrl("/login-form")
                        .permitAll())
                .headers().frameOptions().sameOrigin()
                .and().csrf().ignoringAntMatchers("/h2-console/**");
                http.exceptionHandling().accessDeniedHandler(accessDeniedHandler);

        return http.build();

    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}
