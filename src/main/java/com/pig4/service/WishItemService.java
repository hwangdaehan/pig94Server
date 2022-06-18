package com.pig4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pig4.repository.WishItemRepository;
import com.pig4.vo.WishVO;

@Service
public class WishItemService {
	
	@Autowired
	WishItemRepository wishItemRepository;
	
	
	public WishVO save(WishVO wishVO) {
		wishVO = wishItemRepository.save(wishVO);
		return wishVO;
	}
	
	public List<WishVO> selectList() {
		List<WishVO> resultList = wishItemRepository.findByDeleteYn("N");
		return resultList;
	}
	
	public WishVO selectDetail(long id) {
		WishVO result = wishItemRepository.findBySeqAndDeleteYn(id, "N");
		
		return result;
	}
	
}
