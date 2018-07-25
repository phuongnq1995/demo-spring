package com.spring.mvc.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.mvc.model.CustomerEntity;
import com.spring.mvc.model.Message;
import com.spring.mvc.service.CustomerService;

@Controller
public class WebSocketController {
	
	@Autowired
	CustomerService service;
	
	@Autowired
	SimpMessagingTemplate template;
	
	@RequestMapping("chatpage")
	public String index() {
		return "chat";
	}
	
	@MessageMapping("/chat" )
	@SendTo("/topic/messages")
	public Map<String, Object> send(@Payload Message message) throws Exception {
	    String time = new SimpleDateFormat("HH:mm").format(new Date());
	    Map<String, Object> map = new HashMap<>();
	    map.put("from", message.getFrom());
	    map.put("text", message.getText());
	    map.put("time", time);
	    List<CustomerEntity> customer = service.findAll();
	    List<Map<String, String>> array = new ArrayList<>();
	    for(int i = 0 ; i < array.size(); i++) {
	    	Map<String, String> object = new HashMap<>();
	    	object.put("name", customer.get(i).getName());
	    	object.put("email", customer.get(i).getEmail());
	    	object.put("birthday", 
	    		new SimpleDateFormat("dd/MM/yyyy").format(customer.get(i).getBirthDay()));
	    	array.add(object);
	    }
	    map.put("customer", array);
	    return map;
	}
}
