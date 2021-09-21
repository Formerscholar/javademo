package com.chad.aopdemo.controller;

import com.chad.aopdemo.aop.inter.NewWebLog;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * aop contriller
 *
 * @author 2319315514@qq.com
 * @date 2021/09/19 16:04:14
 */
@RestController
@RequestMapping("aop")
public class AopContriller {
	
	/**
	 * aop演示
	 *
	 * @param id id
	 * @return {@code String}
	 */
	@GetMapping("demo")
	//@WebLog(desc = "测试aop方法")
	@NewWebLog(desc = "测试aop方法")
	public String aopDemo(@RequestParam String id) {
		return id;
	}
}
