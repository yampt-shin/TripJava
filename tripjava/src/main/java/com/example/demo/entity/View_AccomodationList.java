package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="view_accomodation_list")
@NoArgsConstructor
public class View_AccomodationList {
	
	@Id
	private int accomodationNo;
    private String accomodationAddr;
    private String accomodationName;
    private String accomodationPrice;
    private String accomodationFileFname1;
    private int reviewCount;
    private double avgReviewStar;
    
}