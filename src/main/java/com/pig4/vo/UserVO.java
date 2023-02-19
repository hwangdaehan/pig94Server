package com.pig4.vo;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@EntityListeners(AuditingEntityListener.class)
@Entity(name="pg_user") 
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SQLDelete(sql = "UPDATE pg_user SET DELETE_DATE = SYSDATE()  WHERE seq = ?")
@Where(clause = "DELETE_DATE IS NULL")
public class UserVO {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private long seq;
	
	@Column(name="social_login_type")
	private String socialLoginType;
	
	private String id;
	
	private String name;
	
	private String gender;
	
	@Column(name="age_group")
	private int ageGroup;
	
	@Column(name="user_state")
	private int userState;
	
	private String password;
	
	@Builder
	public UserVO(String socialLoginType, String id, String name, String gender, int ageGroup, int userState, String password) {
		this.socialLoginType = socialLoginType;
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.ageGroup = ageGroup;
		this.userState = userState;
		this.password = password;
	}
}
