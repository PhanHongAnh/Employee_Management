package com.hrsmanager.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.hrsmanager.authentication.EmployeeService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	EmployeeService myDBAuthenticationService;
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
		auth
		.inMemoryAuthentication()
			.withUser("honganh").password("20002000").roles("USER").and()
			.withUser("lien").password("20000000").roles("ADMIN");
	}
	
	@Override
	protected void configure (HttpSecurity http) throws Exception{
		http.authorizeRequests().antMatchers("/","/login","/logout").anonymous();
		http.authorizeRequests().antMatchers("/profile").hasAnyRole("USER", "ADMIN");
		http.authorizeRequests().antMatchers("/employeeInfo").hasRole("ADMIN");
		
	}
}
