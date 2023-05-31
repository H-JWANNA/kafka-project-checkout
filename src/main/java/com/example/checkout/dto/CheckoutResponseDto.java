package com.example.checkout.dto;

import java.time.LocalDateTime;

public record CheckoutResponseDto(
	Long checkoutId,

	Long memberId,

	Long productId,

	Long amount,

	String shippingAddress,

	LocalDateTime createdAt
) {
}
