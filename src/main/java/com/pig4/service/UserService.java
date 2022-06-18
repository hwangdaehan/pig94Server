package com.pig4.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pig4.repository.UserRepository;
import com.pig4.vo.UserVO;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	public List<UserVO> findAll(){
		List<UserVO> userList =new ArrayList<UserVO>();
 		userRepository.findAll().forEach(e -> userList.add(e));
 		return userList;
	}
	
	public Optional<UserVO> findBySeq(long seq){
		Optional<UserVO> userInfo = userRepository.findBySeq(seq);
		return userInfo;
	}
	
	public Optional<UserVO> findById(String id){
		Optional<UserVO> user = userRepository.findById(id);
		return user;
	}
	
	public UserVO save(UserVO userVO) {
		userVO = userRepository.save(userVO);
		return userVO;
	}
}
