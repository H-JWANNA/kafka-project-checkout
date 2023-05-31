package com.example.checkout.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.checkout.dto.CheckoutRequestDto;
import com.example.checkout.service.SaveService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Controller
@Slf4j
public class CheckoutSubmitController {
	private final SaveService saveService;

	@PostMapping("/submitCheckout")
	public String submitCheckout(CheckoutRequestDto requestDto, Model model) {
		log.info(requestDto.toString());

		Long checkoutId = saveService.saveCheckoutData(requestDto);

		model.addAttribute("checkoutId", checkoutId);

		return "submitComplete";
	}
}
