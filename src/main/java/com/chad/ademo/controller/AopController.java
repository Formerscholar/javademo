package com.chad.ademo.controller;

import com.chad.ademo.aop.inter.NewWebLog;
import com.chad.ademo.model.Users;
import com.chad.ademo.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

/**
 * aop contriller
 *
 * @author 2319315514@qq.com
 * @date 2021/09/19 16:04:14
 */
@RestController
@RequestMapping("aop")
public class AopController {
	
	@Autowired
	private UsersService usersService;
	
	/**
	 * aop演示
	 *
	 * @param id id
	 * @return {@code String}
	 */
	@Secured("ROLE_admin")
	@GetMapping("demo/{id}")
	//@WebLog(desc = "测试aop方法")
	@NewWebLog(desc = "测试aop方法")
	public String aopDemo(@PathVariable("id") String id) {
		Users byId = usersService.getById(1);
		System.out.println(byId);
		return id;
	}
}
