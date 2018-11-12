package com.tje.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tje.controller.*;
import com.tje.model.Member;
import com.tje.service.MemberService;

@Controller
public class AJAXConroller {
	
	@Autowired
	private MemberService service;
	
	@RequestMapping(value="/ajaxTest", method=RequestMethod.GET)
	public String ajaxTestPage() {
		return "ajaxTest";
	}
	
	@ResponseBody
	@RequestMapping(value="/ajaxTest", method=RequestMethod.POST)
	public String ajaxTestPage(@RequestBody String strJsonData) {
		System.out.println(strJsonData);
		return "{\"msg : \" : \"Hello AJAX~~!!!\"}";
	}
	@RequestMapping(value="/member/regist", method=RequestMethod.GET)
	public String memberRegistPage() {
		return "/member/registForm";
	}
	
	@ResponseBody
	@RequestMapping(value="/member/checkId/{id}", method=RequestMethod.POST)
	public String checkId(@PathVariable("id") String member_id) {
		System.out.println(member_id);
		Member member =new Member();
		member.setId(member_id);
		
		Member result = service.selectOne(member);
		String msg;
		if( result ==null) {
			msg="사용가능한 ID 입니다.";
		}else {
			msg ="이미 사용중인 ID입니다.";
		}
		return "{\"value\" : \""+msg+ "\"}";
		
	}
}
