package com.example.demo.entity;

import java.time.LocalDate;

import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
@Table(name = "accomodation_review")
@SequenceGenerator(
        name="ACCOMODATION_REVIEW_SEQ_GEN",
        sequenceName = "ACCOMODATION_REVIEW_SEQ",
    	initialValue = 1,
    	allocationSize = 1
)
@EntityListeners(AuditingEntityListener.class)
public class AccomodationReview {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "ACCOMODATION_REVIEW_SEQ_GEN"
    )
    @Column(name = "accomodation_review_no")
    private int accomodationReviewNo;
    @Column(name = "accomodation_review_star")
    private double accomodationReviewStar;
    @Column(name = "accomodation_review_content")
    private String accomodationReviewContent;
    
    @LastModifiedDate
    @Temporal(TemporalType.DATE)
    @Column(name = "accomodation_review_date")
    private LocalDate accomodationReviewDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "users_no", foreignKey = @ForeignKey(name = "fk_accom_review_to_users"))
    private Users users;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "accomodation_no", foreignKey = @ForeignKey(name = "fk_accom_review_to_accom"))
    private Accomodation accomodation;
	public AccomodationReview(int accomodationReviewNo, double accomodationReviewStar, String accomodationReviewContent,
			LocalDate accomodationReviewDate, Users users, Accomodation accomodation) {
		super();
		this.accomodationReviewNo = accomodationReviewNo;
		this.accomodationReviewStar = accomodationReviewStar;
		this.accomodationReviewContent = accomodationReviewContent;
		this.accomodationReviewDate = accomodationReviewDate;
		this.users = users;
		this.accomodation = accomodation;
	}
	public AccomodationReview() {
		super();
		// TODO Auto-generated constructor stub
	}
}
