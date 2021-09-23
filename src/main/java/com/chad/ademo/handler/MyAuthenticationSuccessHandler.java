package com.chad.ademo.handler;

import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@AllArgsConstructor
public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
	private String url;
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
	                                    Authentication authentication) throws IOException, ServletException {
		httpServletResponse.sendRedirect(url);
	}
}
