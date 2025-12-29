package com.telemedicine.controlles;

import java.security.Principal;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ch.qos.logback.core.model.Model;

@Controller
@RequestMapping("/Doctor")
public class Doctor_controller {
	
	@GetMapping
	public String Doctor(Principal prin, Model mo){
		System.out.print(prin.getName());
		  
		return "Doctor_page";
	}

}
