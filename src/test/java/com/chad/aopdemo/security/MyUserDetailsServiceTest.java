package com.chad.aopdemo.security;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * MyUserDetailsService Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>9�� 22, 2021</pre>
 */
public class MyUserDetailsServiceTest {
	
	@Before
	public void before() throws Exception {
	}
	
	@After
	public void after() throws Exception {
	}
	
	/**
	 * Method: loadUserByUsername(String username)
	 */
	@Test
	public void testLoadUserByUsername() throws Exception {
//TODO: Test goes here...
		String password = new BCryptPasswordEncoder().encode("123123");
		System.out.println(password);
	}
	
	
} 
