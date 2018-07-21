package com.spring.mvc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.spring.mvc.dto.AddressDTO;
import com.spring.mvc.dto.CustomerDTO;
import com.spring.mvc.helper.CustomerHelper;
import com.spring.mvc.service.CustomerService;
import com.spring.mvc.validator.CustomerValidator;

@Controller
@RequestMapping("/")
public class HelloController {

	@Autowired
	CustomerHelper helper;

	@Autowired
	CustomerValidator customerValidator;

	@Autowired
	CustomerService customerService;

	@InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.addValidators(customerValidator);
    }

	@ModelAttribute
	public CustomerDTO getCustomer() {
		CustomerDTO customerDTO = new CustomerDTO();
		List<AddressDTO> listAddress = new ArrayList<>();
		for(int i = 0; i < 2; i++) {
			listAddress.add(new AddressDTO());
		}
		customerDTO.setListAddress(listAddress);
		return customerDTO;
	}

	@ExceptionHandler(Exception.class)
	public String errorPage(Exception e, Model model) {
		e.printStackTrace();
		return "404";
	}

	@RequestMapping
	public String index(CustomerDTO customerDTO) {
		helper.populatorCustomer(customerDTO);
		return "home";
	}

	// Put BindingResult after @Valid or @Validated
	@RequestMapping(value = "submit", method = RequestMethod.POST)
	public String submit(@Valid CustomerDTO customerDTO, BindingResult bindingResult,
			RedirectAttributes redirectAttributes) throws Exception {
		if (bindingResult.hasErrors()) {
			return "home";
		}
		customerService.create(customerDTO);
		redirectAttributes.addFlashAttribute(customerDTO);
		return "redirect:/hello";
	}

}
