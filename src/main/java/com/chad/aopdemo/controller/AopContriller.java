package com.chad.aopdemo.controller;

import com.chad.aopdemo.aop.inter.NewWebLog;
import com.chad.aopdemo.aop.inter.WebLog;
import org.springframework.web.bind.annotation.*;

/**
 * aop contriller
 *
 * @author Administrator
 * @date 2021/09/19
 */
@RestController
@RequestMapping("aop")
public class AopContriller {
	
	/**
	 * aop演示
	 *
	 * @param id id
	 * @return {@link String}
	 */
	@GetMapping("demo")
	//@WebLog(desc = "测试aop方法")
	@NewWebLog(desc = "测试aop方法")
	public String aopDemo(@RequestParam String id) {
		return id;
	}
}
