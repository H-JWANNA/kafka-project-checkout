package com.example.checkout.dto;

public record CheckoutRequestDto(
	Long memberId,

	Long productId,

	Long amount,

	String shippingAddress
) {
}
