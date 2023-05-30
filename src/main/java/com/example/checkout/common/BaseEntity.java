package com.example.checkout.common;

import java.time.LocalDateTime;

import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {
	@CreatedDate
	@ColumnDefault("CURRENT_TIMESTAMP()")
	@Column(name = "createdAt", nullable = false, updatable = false)
	private LocalDateTime createdAt = LocalDateTime.now();

	@LastModifiedDate
	@ColumnDefault("CURRENT_TIMESTAMP()")
	@Column(name = "lastModifiedAt", nullable = false)
	private LocalDateTime lastModifiedAt = LocalDateTime.now();
}
