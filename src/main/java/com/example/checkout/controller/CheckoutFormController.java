package com.example.checkout.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class CheckoutFormController {

	@GetMapping("/checkoutForm")
	public String checkOutForm(Model model) {
		log.info("checkoutForm......");
		return "checkoutForm";
	}
}
