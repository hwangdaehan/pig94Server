package com.pig4.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.pig4.vo.WishVO;

@Repository
@EnableJpaRepositories
public interface WishItemRepository extends JpaRepository<WishVO, Long> {
	
	public List<WishVO> findByDeleteYn(String deleteYn);
	
	public WishVO findBySeqAndDeleteYn(long id, String deleteYn);
}
