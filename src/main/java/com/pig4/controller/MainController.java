package com.pig4.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pig4.common.CommonUtils;
import com.pig4.service.UserService;
import com.pig4.vo.ResultVO;
import com.pig4.vo.UserVO;

@RestController
@RequestMapping("/user")
public class MainController {
	@Autowired
	UserService userService;
	
	
	@RequestMapping(value="test")
	@ResponseBody public String test() {
		return "asd";
	}
	
	@GetMapping(value="list", produces= {MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody public List<UserVO> findList(){
		return userService.findAll();
	}
	
	@GetMapping(value="info/{seq}", produces= {MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody public Optional<UserVO> findInfo(@PathVariable("seq")Long seq){
		return userService.findBySeq(seq);
	}
	
	//회원등록
    @PostMapping(value="/save")
    @ResponseBody
    public ResultVO save(@ModelAttribute UserVO userVO){
    	ResultVO resultVO = new ResultVO();
    	
    	String salt = CommonUtils.Salt();
		//비밀번호 암호화
		String enc_pw = CommonUtils.SHA512(userVO.getPassword(), salt);
		userVO.setPassword(enc_pw);
		
    	UserVO user = userService.save(userVO);
    	
    	if(!CommonUtils.isEmpty(user)) {
    		resultVO.setData(user);
    		resultVO.setResult_code(0);
    		resultVO.setResult_msg("회원 가입 설공");
    	}else {
    		resultVO.setResult_code(99);
    		resultVO.setResult_msg("회원 가입 실패");
    	}
        return resultVO ;
    }
    
    @PostMapping(value="/login")
    @ResponseBody
    public ResultVO login(@RequestParam String id, @RequestParam String password) {
    	ResultVO resultVO =new ResultVO();
    	Optional<UserVO> userVO = userService.findById(id);
    	
    	if(!CommonUtils.isEmpty(userVO.get().getSeq())) {
    		String salt = CommonUtils.Salt();
    		//비밀번호 암호화
    		String enc_pw = CommonUtils.SHA512(password, salt);
    		
    		if(userVO.get().getPassword().equals(enc_pw)) {
    			resultVO.setData(userVO);
    			resultVO.setResult_code(0);
    			resultVO.setResult_msg("로그인 성공");
    		}else {
    			resultVO.setResult_code(99);
    			resultVO.setResult_msg("로그인 실패 (비밀번호 틀림)");
    		}
    		
    	}else {
    		resultVO.setResult_code(99);
    		resultVO.setResult_msg("로그인 실패 (없는 계정)");
    	}
    	return resultVO;
    }
    
}
