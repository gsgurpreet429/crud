package com.crud.Crud.entity;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@Builder(toBuilder = true)
@Table(name = "PRODUCT")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long productId;

	private String productName;
	
	private String description;
	
	@CreationTimestamp
	private Date rowAddStp;
	
	private Date rowUpdateStp;
	
	private String rowAddUserId;
	
	private String rowUpdateUserId;
	
}
