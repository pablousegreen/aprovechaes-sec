package com.aprovechaessec.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
//@ConditionalOnProperty(value = "app.security.basic.enabled", havingValue = "false")
public class WebSecurityConfig /*extends WebSecurityConfigurerAdapter*/{

//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//	    http.csrf().disable()
//	            .authorizeRequests()
//	            .antMatchers("/**").permitAll()
//	            .anyRequest().authenticated();
//	}
	//--------------------------------------
//	@Value("${security.enabled:false}")
//    private boolean securityEnabled;
//
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        if (securityEnabled)
//            web.ignoring().antMatchers("/**");
//        else
//            web.ignoring().antMatchers("/**");
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        if (securityEnabled)
//            http.csrf().disable().authorizeRequests()
//                    .anyRequest().authenticated()
//                    .and().httpBasic();
//    }
	//---------------------------
	
//	@Override
//    protected void configure(HttpSecurity http) throws Exception{
//        http.authorizeRequests().antMatchers("/").permitAll();
//    }
//	
//	@Bean
//    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
//        http.authorizeExchange().anyExchange().permitAll();
//        return http.build();
//    }
	
//	@Override
//    protected void configure(HttpSecurity http) throws Exception{
//        http.authorizeRequests().antMatchers("/").permitAll();
//    }
	
}
