package com.spring.mvc.controller;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.spring.mvc.dto.AjaxDTO;
import com.spring.mvc.helper.CustomerHelper;
import com.spring.mvc.model.CustomerEntity;
import com.spring.mvc.service.CustomerService;

@Controller
public class AjaxController {
	
	@Autowired
	CustomerHelper helper;

	@Autowired
	CustomerService customerService;
	
	@ModelAttribute
	public AjaxDTO getCustomer() {
		return new AjaxDTO();
	}
	
	@ExceptionHandler(Exception.class)
	public String errorPage(Exception e, Model model) {
		e.printStackTrace();
		return "404";
	}
	
	@RequestMapping("hello")
	public String sayHello() {
		return "hello";
	}
	
	@RequestMapping("getAjaxJson")
	@ResponseBody
	public Map<String, String> getAjaxMap(@Validated AjaxDTO ajaxDTO, BindingResult bindingResult) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		if(bindingResult.hasErrors()) {
			map.put("validated", "false");
		}
		CustomerEntity entity = customerService.getCustomerByName(ajaxDTO.getCustomerName());
		map.put("id", entity.getId());
		map.put("name", entity.getName());
		map.put("email", entity.getEmail());
		map.put("birthDay", new SimpleDateFormat("dd/MM/yyyy").format(entity.getBirthDay()));
		map.put("validated", "true");
		return map;
	}
	
	@RequestMapping("getAjaxHtml")
	public String getAjaxHtml(Model model) {
		model.addAttribute("list", customerService.findAll());
		return "ajaxHtml";
	}
}
