package com.aprovechaessec.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/*@Configuration
@EnableWebSecurity*/
public class SecurityConfig /*extends WebSecurityConfigurerAdapter*/ {
	
//	 @Autowired
//	 private MongoDBAuthenticationProvider authenticationProvider;

	
	/*@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
//		auth.jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery(query);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{		
		super.configure(http);
		http.authorizeRequests().antMatchers("/register", "/", "/about", "/login", "/css/**", "/webjars/**")
		.permitAll().anyRequest().authenticated().and().formLogin().loginPage("/login").permitAll()
		.defaultSuccessUrl("/profile").and().logout().logoutSuccessUrl("/login");	
		
	}*/

}
