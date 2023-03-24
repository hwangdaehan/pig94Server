package com.pig4.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pig4.common.CommonUtils;
import com.pig4.service.WishItemService;
import com.pig4.vo.ResultVO;
import com.pig4.vo.WishVO;
import com.pig4.vo.param.WishParamVO;

@Controller
@RequestMapping(value="/wish")
public class WishItemController {

	
	@Autowired
	WishItemService wishItemService;
	
	@PostMapping(value ="/save")
	@ResponseBody
	public ResultVO insertWishItem(@ModelAttribute WishParamVO paramVO) {
		WishVO  result = wishItemService.save(paramVO);
		
		ResultVO resultVO =new ResultVO();
		
		if(!CommonUtils.isEmpty(result)) {
			resultVO.setData(result);
			resultVO.setResult_code(0);
			resultVO.setResult_msg("위시리스트가 성공적으로 등록되었습니다");
		}else {
			resultVO.setResult_code(99);
			resultVO.setResult_msg("위시리스트 등록 중 오류 발생");
		}
	
		return resultVO;
	}
	
	
	@GetMapping(value = "/list")
	@ResponseBody
	public ResultVO wishItemList(@RequestParam long userSeq) {
		List<WishVO> resultList = wishItemService.selectUserList(userSeq);
		
		ResultVO resultVO = new ResultVO();
		
		if(!CommonUtils.isEmpty(resultList)) {
			resultVO.setData(resultList);
			resultVO.setResult_code(0);
			resultVO.setResult_msg("위시리스트가 성공적으로 조회되었습니다");
		}else {
			resultVO.setResult_code(99);
			resultVO.setResult_msg("위시리스트 조회 중 오류 발생");
		}
	
		return resultVO;	
	}
	
	@GetMapping(value = "/detail")
	@ResponseBody
	public ResultVO wishItemDetail(@ModelAttribute WishVO wishVO) {
		WishVO detailVO = wishItemService.selectDetail(wishVO.getSeq());
		
		ResultVO resultVO = new ResultVO();
		
		if(!CommonUtils.isEmpty(detailVO)) {
			resultVO.setData(detailVO);
			resultVO.setResult_code(0);
			resultVO.setResult_msg("위시 아이템이 성공적으로 조회되었습니다");
		}else {
			resultVO.setResult_code(99);
			resultVO.setResult_msg("위시 아이템 조회 중 오류 발생");
		}
	
		return resultVO;	
	}

}
