package com.hrsmanager.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;

import com.hrsmanager.authentication.EmployeeService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(employeeService);
	}
	
	private CsrfTokenRepository csrfTokenRepository() 
	{ 
	    HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository(); 
	    repository.setSessionAttributeName("_csrf");
	    return repository; 
	}
	
	@Override
	protected void configure (HttpSecurity http) throws Exception{
	    http.csrf()
	    	.csrfTokenRepository(csrfTokenRepository());
		http.authorizeRequests().antMatchers("/","/login","/logout").anonymous();
		/*http.authorizeRequests().antMatchers("/profile").hasAnyRole("USER", "ADMIN");*/
		
		http.authorizeRequests().and().formLogin()
		.loginPage("/login")
		.defaultSuccessUrl("/profile")
		.failureUrl("/login?error=true")
		.usernameParameter("email")
		.passwordParameter("password")
		.and().logout().logoutUrl("/logout").logoutSuccessUrl("/logoutSuccessUrl");
	}
}
