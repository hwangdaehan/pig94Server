package com.pig4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pig4.repository.WishItemRepository;
import com.pig4.vo.WishVO;
import com.pig4.vo.param.WishParamVO;

@Service
public class WishItemService {
	
	@Autowired
	WishItemRepository wishItemRepository;
	
	
	public WishVO save(WishParamVO paramVO) {
		WishVO wish = WishVO.builder().userSeq(paramVO.getUserSeq()).productName(paramVO.getProductName())
									  .category(paramVO.getCategory()).brandName(paramVO.getBrandName())
									  .price(paramVO.getPrice()).saveMoney(paramVO.getSaveMoney())
									  .purchaseStatus(paramVO.getPurchaseStatus()).build();
		
		wishItemRepository.save(wish);
		
		return wish;
	}
	
	public List<WishVO> selectUserList(long userSeq) {
		List<WishVO> resultList = wishItemRepository.findByUserSeq(userSeq);
		return resultList;
	}
	
	public WishVO selectDetail(long id) {
		WishVO result = wishItemRepository.findBySeqAndDeleteYn(id, "N");
		
		return result;
	}
	
}
