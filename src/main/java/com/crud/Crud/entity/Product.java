package com.crud.Crud.entity;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedBy;

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
	

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getRowUpdateStp() {
		return rowUpdateStp;
	}

	public void setRowUpdateStp(Date rowUpdateStp) {
		this.rowUpdateStp = rowUpdateStp;
	}

	public String getRowUpdateUserId() {
		return rowUpdateUserId;
	}

	public void setRowUpdateUserId(String rowUpdateUserId) {
		this.rowUpdateUserId = rowUpdateUserId;
	}

	public String getRowAddUserId() {
		return rowAddUserId;
	}

	public void setRowAddUserId(String rowAddUserId) {
		this.rowAddUserId = rowAddUserId;
	}
	
	
	
}
