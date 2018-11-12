package com.tje.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.tje.model.Member;
import com.tje.service.*;

@RestController
public class MemberListRestController {
	@Autowired
	private MemberService service;
	
	@RequestMapping(value="/member/list" , method=RequestMethod.POST)
	public String memberListForm() {
		List<Member> list = service.selectList();
		Gson gson= new Gson();
		String json= gson.toJson(list);
		
		
		return json ;
	}
}
