package com.pig4.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="pg_wish")
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
	private int purchaseStatus;
	
	@Column(name="delete_yn")
	private String deleteYn;
	
	@Column(name="delete_date")
	private String deleteDate;
	
	@Column(name="update_date")
	private String updateDate;
	
	@Column(name="product_link")
	private String productLink;
	
	
	@Builder
	public WishVO() {
		super();
	}


	public long getSeq() {
		return seq;
	}


	public void setSeq(long seq) {
		this.seq = seq;
	}


	public long getUserSeq() {
		return userSeq;
	}


	public void setUserSeq(long userSeq) {
		this.userSeq = userSeq;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public int getCategory() {
		return category;
	}


	public void setCategory(int category) {
		this.category = category;
	}


	public String getBrandName() {
		return brandName;
	}


	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}


	public long getPrice() {
		return price;
	}


	public void setPrice(long price) {
		this.price = price;
	}


	public long getSaveMoney() {
		return saveMoney;
	}


	public void setSaveMoney(long saveMoney) {
		this.saveMoney = saveMoney;
	}


	public int getPurchaseStatus() {
		return purchaseStatus;
	}


	public void setPurchaseStatus(int purchaseStatus) {
		this.purchaseStatus = purchaseStatus;
	}


	public String getDeleteYn() {
		return deleteYn;
	}


	public void setDeleteYn(String deleteYn) {
		this.deleteYn = deleteYn;
	}


	public String getDeleteDate() {
		return deleteDate;
	}


	public void setDeleteDate(String deleteDate) {
		this.deleteDate = deleteDate;
	}


	public String getUpdateDate() {
		return updateDate;
	}


	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}


	public String getProductLink() {
		return productLink;
	}


	public void setProductLink(String productLink) {
		this.productLink = productLink;
	}
}
