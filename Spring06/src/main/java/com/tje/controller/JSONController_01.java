package com.tje.controller;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Random;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tje.model.*;

@Controller
public class JSONController_01 {
	
	
	@ResponseBody
	@RequestMapping("/viewJson_01")
	public String viewJson_1() {
		String jsonData ="{id : \"111\",name : \"AAA\",age : 11}";
		return jsonData;
	}
	@ResponseBody
	@RequestMapping("/viewJson_02")
	public String viewJson_2() {
		Gson gson =new Gson();
		Member member = new Member();
		
		member.setId("memberId01");
		member.setPw("111");
		member.setName("111");
		String jsonData = gson.toJson(member);
		return jsonData;
	}
	@ResponseBody
	@RequestMapping("/viewJson_03")
	public String viewJson_3() {
		Gson gson =new Gson();
		String jsonData = "{\"id\":\"AAA\",\"pw\":\"abc1235467\",\"name\":\"BBB\"}";

		Member member = gson.fromJson(jsonData,Member.class );	
		System.out.println(member.getId());
		System.out.println(member.getPw());
		System.out.println(member.getName());
		return jsonData;
	}
	
	
	@ResponseBody
	@RequestMapping("/viewJson_04")
	public String viewJson_4() {
		Gson gson =new Gson();
		ArrayList<Member> list = new ArrayList<>();
		
		
		for(int i =1 ; i<=3 ; i++) {
			Member member = new Member();
			Random random =new Random();
			
			member.setId("id_"+random.nextInt(5000));
			member.setPw("pw_"+random.nextInt(5000));
			member.setName("name_"+random.nextInt(5000));
			list.add(member);
		}
		
		
		
		String jsonData = gson.toJson(list);
		return jsonData;
	}
	@ResponseBody
	@RequestMapping("/viewJson_05")
	public String viewJson_5() {
		Gson gson =new Gson();
		String jsonData = "[{\"id\":\"id_2838\",\"pw\":\"pw_590\",\"name\":\"name_2385\"},{\"id\":\"id_1234\",\"pw\":\"pw_120\",\"name\":\"name_1385\"},"
				+ "{\"id\":\"id_8678\",\"pw\":\"pw_000\",\"name\":\"name_0965\"},{\"id\":\"id_2838\",\"pw\":\"pw_590\",\"name\":\"name_2385\"}]";
		Type type= new TypeToken<ArrayList<Member>>() {}.getType();
		
		
		ArrayList<Member> list = gson.fromJson(jsonData, type);
		
		
		for(int i =1 ; i<=3 ; i++) {
			Member member = list.get(i);
			System.out.println(member.getId());
			System.out.println(member.getPw());
			System.out.println(member.getName());
		}
		return jsonData;
	}
	
}
