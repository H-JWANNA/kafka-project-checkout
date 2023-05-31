package com.example.checkout.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.example.checkout.dto.CheckoutRequestDto;
import com.example.checkout.dto.CheckoutResponseDto;
import com.example.checkout.entity.CheckoutEntity;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CheckoutMapper {

	CheckoutEntity toEntity(CheckoutRequestDto requestDto);

	CheckoutResponseDto toDto(CheckoutEntity entity);
}
