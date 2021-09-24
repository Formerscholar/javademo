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
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;


@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private MyUserDetailsService myUserDetailsService;
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private PersistentTokenRepository persistentTokenRepository;
	
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
		http.rememberMe()
			.rememberMeParameter("remember-me")   //修改默认参数名，默认是remember-me
			.tokenValiditySeconds(60 * 60 * 24 * 14)  //设置记住我有效时间，单位是秒，默认是14天
			.rememberMeCookieName("remember-me")    //修改rememberMe的cookie名称，默认是remember-me
			.tokenRepository(persistentTokenRepository)  //配置用户登录标记的持久化工具对象
			.userDetailsService(userDetailsService());  //配置自定义的UserDerailsService接口实现类对象
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
	
	@Bean
	public PersistentTokenRepository persistentTokenRepository(DataSource dataSource) {
		
		JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
		tokenRepository.setDataSource(dataSource);
		
		//设置启动的时候，在数据库中创建表格persistent_logins。只有数据库中不存在表格的时候可以使用。默认值是false
		tokenRepository.setCreateTableOnStartup(true);
		return tokenRepository;
	}
}
