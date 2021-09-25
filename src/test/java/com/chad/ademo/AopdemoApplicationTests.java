package com.chad.ademo;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AopdemoApplicationTests {
	
	
	
	@Test
	public void contextLoads() {
		JwtBuilder jwtBuilder = Jwts.builder()
			.setId("123")
			.setSubject("Rose")
			.setIssuedAt(new Date())
			.signWith(SignatureAlgorithm.HS256, "xxxx");
		String compact = jwtBuilder.compact();
		System.out.println(compact);
	}
	
	@Test
	public void paseToken(){
		Object xxxx = Jwts.parser()
			.setSigningKey("xxxx")
			.parse("eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIxMjMiLCJzdWIiOiJSb3NlIiwiaWF0IjoxNjMyNTUzMzA3fQ" +
				".NqHfF1M6n8CM4hJVDkANuDyfLJjkpnGCZgcfTf7G_q8")
			.getBody();
		System.out.println(xxxx);
	}
	
}
