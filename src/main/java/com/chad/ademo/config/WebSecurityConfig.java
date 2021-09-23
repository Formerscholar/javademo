package com.chad.ademo.config;

import com.chad.ademo.handler.MyAuthenticationFailureHandler;
import com.chad.ademo.handler.MyAuthenticationSuccessHandler;
import com.chad.ademo.security.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private MyUserDetailsService myUserDetailsService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.formLogin()
			.loginPage("/login.html")
			.loginProcessingUrl("/login")
			//.successForwardUrl("/toMain")
			.successHandler(new MyAuthenticationSuccessHandler("main.html"))
			//.failureForwardUrl("/toError")
			.failureHandler(new MyAuthenticationFailureHandler("error.html"));
		http.authorizeRequests()
			.antMatchers("/login.html", "/error.html", "/images/*.png")
			.permitAll()
			//.antMatchers("/vip.html").hasAnyAuthority("vip")
			.anyRequest()
			.authenticated();
		http.csrf()
			.disable();
	}
	
	//配置用户
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(myUserDetailsService)
			.passwordEncoder(passwordEncoder());
	}
	
	//密码编码器
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
