package com.pig4.vo.param;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WishParamVO {

	private int seq;
	private long userSeq;
	private String productName;
	private int category;
	private String brandName;
	private int price;
	private int saveMoney;
	private String purchaseStatus;
	private String deleteYn;
	private String deleteDate;
	private String productLink;
	
	
}
