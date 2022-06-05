package com.pig4.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.pig4.vo.UserVO;

@Repository
@EnableJpaRepositories
public interface UserRepository extends JpaRepository<UserVO, Long> {
	
	public Optional<UserVO> findBySeq(long seq);

	public Optional<UserVO> findById(String id);
}
