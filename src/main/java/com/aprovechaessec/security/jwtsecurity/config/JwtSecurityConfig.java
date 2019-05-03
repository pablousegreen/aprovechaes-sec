package com.aprovechaessec.security.jwtsecurity.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.aprovechaessec.security.jwtsecurity.security.JwtAuthenticationEntryPoint;
import com.aprovechaessec.security.jwtsecurity.security.JwtAuthenticationProvider;
import com.aprovechaessec.services.UserServiceImpl;

//@EnableGlobalMethodSecurity(prePostEnabled = true)

@Configuration
@EnableWebSecurity
@ComponentScan
public class JwtSecurityConfig extends WebSecurityConfigurerAdapter {


//    @Autowired
//    private JwtAuthenticationProvider authenticationProvider;
//    @Autowired
//    private JwtAuthenticationEntryPoint entryPoint;
    @Autowired
    UserServiceImpl userService;

//    @Bean
//    public AuthenticationManager authenticationManager() {
//        return new ProviderManager(Collections.singletonList(authenticationProvider));
//    }

//    @Bean
//    public JwtAuthenticationTokenFilter authenticationTokenFilter() {
//        JwtAuthenticationTokenFilter filter = new JwtAuthenticationTokenFilter();
//        filter.setAuthenticationManager(authenticationManager());
//        filter.setAuthenticationSuccessHandler(new JwtSuccessHandler());
//        return filter;
//    }
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    	// TODO Auto-generated method stub
    	auth.userDetailsService(userService);
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	http.authorizeRequests().antMatchers("/register", "/", "/about", "/login", "/css/**", "/webjars/**").permitAll()
		.antMatchers("/profile").hasAnyRole("USER,ADMIN")
//    	.antMatchers("/profile").hasAnyRole("ADMIN")
		.antMatchers("/users","/addTask").hasRole("ADMIN")
		.and().formLogin().loginPage("/login").permitAll()
		.defaultSuccessUrl("/profile").and().logout().logoutSuccessUrl("/login");
    	
//        http.csrf().disable()
//                .authorizeRequests().antMatchers("**/rest/**").authenticated()
//                .and()
//                .exceptionHandling().authenticationEntryPoint(entryPoint)
//                .and()
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//
//        http.addFilterBefore(authenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class);
//        http.headers().cacheControl();

    }
    
    @Bean
    public PasswordEncoder passwordEncoder() {
    	return new BCryptPasswordEncoder();
    }
}
