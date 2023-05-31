package com.example.checkout.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.checkout.Repository.CheckoutRepository;
import com.example.checkout.dto.CheckoutRequestDto;
import com.example.checkout.dto.CheckoutResponseDto;
import com.example.checkout.entity.CheckoutEntity;
import com.example.checkout.mapper.CheckoutMapper;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Service
@Slf4j
public class SaveService {
	private static final String CHECKOUT_COMPLETE_TOPIC_NAME = "checkout.complete.v1";

	private final KafkaTemplate<String, String> kafkaTemplate;

	private final CheckoutMapper mapper;

	private final CheckoutRepository checkoutRepository;

	private final ObjectMapper objectMapper = new ObjectMapper()
		.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

	public Long saveCheckoutData(CheckoutRequestDto requestDto) {
		CheckoutEntity checkout = save(requestDto);
		CheckoutResponseDto responseDto = mapper.toDto(checkout);

		sendToKafka(responseDto);

		return checkout.getCheckoutId();
	}

	private CheckoutEntity save(CheckoutRequestDto requestDto) {
		CheckoutEntity checkout = mapper.toEntity(requestDto);

		return checkoutRepository.save(checkout);
	}

	private void sendToKafka(CheckoutResponseDto responseDto) {
		try {
			String jsonInString = objectMapper.writeValueAsString(responseDto);
			kafkaTemplate.send(CHECKOUT_COMPLETE_TOPIC_NAME, jsonInString);
			log.info("success send to kafka");
		} catch (Exception e) {
			log.error("sendToKafka ", e);
		}
	}
}
