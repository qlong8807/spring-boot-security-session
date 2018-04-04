/*
 * Copyright 2014-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.zz;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@Controller
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@RequestMapping("/")
	public String hello(Model model) {
		model.addAttribute("hello", "world");
		return "index";
	}
	
	@GetMapping("/login")
	public String login() {
		System.err.println("login");
		return "index";
	}
	
	@RequestMapping("/home")
	public String home(HttpServletRequest request) {
		
		System.err.println("home,sessionId:"+request.getSession().getId());
		return "home";
	}
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request) {
		System.err.println("logout,sessionId:"+request.getSession().getId());
		return "index";
	}
}
