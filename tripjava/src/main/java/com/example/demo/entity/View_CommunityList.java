package com.example.demo.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="view_community_list")
@NoArgsConstructor
public class View_CommunityList {
	
		@Id
		private int communityNo;
	    private CommunityCategory communityCategory;
	    private CommunitySelect communitySelect;
	    private String communityTitle;
	    private int communityHit;
	    private Date communityDate;
	    private String communityAddr;
	    private String usersName;
	    private int communityLike;
	    private int commentary;
 
}

