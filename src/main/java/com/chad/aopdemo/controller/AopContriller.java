package com.chad.aopdemo.controller;

import com.chad.aopdemo.aop.inter.NewWebLog;
import com.chad.aopdemo.aop.inter.WebLog;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("aop")
public class AopContriller {
	
	@GetMapping("demo")
	//@WebLog(desc = "测试aop方法")
	@NewWebLog(desc = "测试aop方法")
	public String aopDemo(@RequestParam String id) {
		return id;
	}
}
