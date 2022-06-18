package com.pig4.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="pg_user")
public class UserVO {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private long seq;
	
	@Column(name="social_login_type")
	private String socialLoginType;
	
	@Column
	private String id;
	
	@Column
	private String name;
	
	@Column
	private String gender;
	
	@Column(name="age_group")
	private int ageGroup;
	
	@Column(name="user_state")
	private int userState;
	
	@Column
	private String password;
	
	@Builder
	public UserVO() {
		super();
	}
	
	
	public long getSeq() {
		return seq;
	}

	public void setSeq(long seq) {
		this.seq = seq;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAgeGroup() {
		return ageGroup;
	}


	public void setAgeGroup(int ageGroup) {
		this.ageGroup = ageGroup;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getSocialLoginType() {
		return socialLoginType;
	}


	public void setSocialLoginType(String socialLoginType) {
		this.socialLoginType = socialLoginType;
	}


	public int getUserState() {
		return userState;
	}


	public void setUserState(int userState) {
		this.userState = userState;
	}

}
