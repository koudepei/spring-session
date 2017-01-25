package com.dongnao.jack.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import redis.clients.jedis.JedisCluster;

@Controller
@RequestMapping("/test")
public class TestController {
	
	@RequestMapping("/login")
	public @ResponseBody String login(HttpServletRequest request,HttpServletResponse response) {
		// TODO Auto-generated method stub
		System.out.println(request.getLocalName());
		System.out.println(request.getContentType());
		System.out.println(request.getSession());
		
		HttpSession session = request.getSession();
		session.setAttribute("jack", "luoyang");
		session.setAttribute("jack1", "luoyang1");
		
		System.out.println(session.getAttribute("jack"));
		
		try {
			System.out.println(InetAddress.getLocalHost().getHostAddress()+"::"+InetAddress.getLocalHost().getHostName());
			return InetAddress.getLocalHost().getHostAddress()+"::"+InetAddress.getLocalHost().getHostName();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping("/queryUser")
	public @ResponseBody String queryUserInfo(HttpServletRequest request,HttpServletResponse response) {
		HttpSession session = request.getSession();
		String name1 = (String) session.getAttribute("jack");
		String name2 = (String) session.getAttribute("jack1");
		
		return name1 + " " + name2;
				
	}
	
	
	
}
