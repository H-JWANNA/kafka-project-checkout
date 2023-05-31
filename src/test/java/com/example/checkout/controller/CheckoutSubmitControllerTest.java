package com.example.checkout.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class CheckoutSubmitControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testPostSubmitCheckout() throws Exception {
		mockMvc.perform(post("/submitCheckout")
				.param("memberId", "10001")
				.param("productId", "200001")
				.param("amount", "33000")
				.param("shippingAddress", "546"))
			.andExpect(status().isOk())
			.andDo(print());
	}
}
