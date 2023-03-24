package com.pig4.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
@Entity(name="pg_wish")
@SQLDelete(sql = "UPDATE pg_wish SET DELETE_DATE = SYSDATE()  WHERE seq = ?")
public class WishVO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long seq;
	
	@Column(name="user_seq")
	private long userSeq;
	
	@Column(name="product_name")
	private String productName;
	
	@Column(name="category")
	private int category;
	
	@Column(name="brand_name")
	private String brandName;
	
	@Column(name="price")
	private long price;
	
	@Column(name="save_money")
	private long saveMoney;
	
	@Column(name="purchase_status")
	private String purchaseStatus;
	
	@Column(name="delete_yn")
	private String deleteYn;
	
	@Column(name="delete_date")
	private String deleteDate;
	
	@Column(name="update_date")
	@LastModifiedDate
	private String updateDate;
	
	@Column(name="product_link")
	private String productLink;
	
	
	@Builder
	public WishVO(long userSeq,String productName, int category, String brandName,int price, int saveMoney, String purchaseStatus) {
		this.userSeq = userSeq;
		this.productName = productName;
		this.category =category;
		this.brandName = brandName;
		this.price =price;
		this.saveMoney = saveMoney;
		this.purchaseStatus =purchaseStatus;
	}
	
}
