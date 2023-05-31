package com.example.checkout.entity;

import com.example.checkout.common.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "CHECKOUT_TABLE")
public class CheckoutEntity extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long checkoutId;

	@Column(name = "memberId")
	private Long memberId;

	@Column(name = "productId")
	private Long productId;

	@Column(name = "amount")
	private Long amount;

	@Column(name = "shippingAddress")
	private String shippingAddress;
}
