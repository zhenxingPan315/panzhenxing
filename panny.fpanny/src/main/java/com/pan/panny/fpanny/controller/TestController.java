package com.pan.panny.fpanny.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pan.panny.fpanny.dao.TestDao;

@Controller
public class TestController {
	
	@Autowired
	private TestDao testDao;
	
	@RequestMapping(value="/test/app")
	@ResponseBody
	public Integer test() {
		Integer count = testDao.count();
		return count;
	}

}
