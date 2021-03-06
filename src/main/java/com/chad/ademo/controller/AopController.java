package com.chad.ademo.controller;

import com.chad.ademo.aop.inter.NewWebLog;
import com.chad.ademo.model.Users;
import com.chad.ademo.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
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
	 * @param id
	 * @return {@code String}
	 */
	//@Secured("ROLE_admin") //角色判断
	//@PreAuthorize("hasAuthority('admin')") // 权限判断
	//@WebLog(desc = "测试aop方法")
	@PreAuthorize("hasRole('admin')")//角色判断
	@GetMapping("demo/{id}")
	@NewWebLog(desc = "测试aop方法")
	public String aopDemo(@PathVariable("id") String id) {
		Users byId = usersService.getById(1);
		System.out.println(byId);
		return id;
	}
}
