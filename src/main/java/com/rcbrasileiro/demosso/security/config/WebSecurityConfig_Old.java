/*
 * package com.rcbrasileiro.demosso.security.config;
 * 
 * package com.rcbrasileiro.demosso.security.config;
 * 
 * import org.springframework.context.annotation.Configuration; import
 * org.springframework.http.HttpMethod; import
 * org.springframework.security.config.annotation.web.builders.HttpSecurity;
 * import org.springframework.security.config.annotation.web.configuration.
 * WebSecurityConfigurerAdapter;
 * 
 * @Configuration public class WebSecurityConfig extends
 * WebSecurityConfigurerAdapter {
 * 
 * @Override protected void configure(HttpSecurity httpSecurity) throws
 * Exception { httpSecurity.authorizeRequests().antMatchers(HttpMethod.OPTIONS,
 * "*").permitAll().and().authorizeRequests()
 * .anyRequest().authenticated().and().oauth2Login(); httpSecurity.cors(); } }
 */