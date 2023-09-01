package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(
        name = "accomodation_like"
)
@SequenceGenerator(
        name="ACCOMODATION_LIKE_SEQ_GEN",
        sequenceName = "ACCOMODATION_LIKE_SEQ",
    	initialValue = 1,
    	allocationSize = 1
) 
public class AccomodationLike {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "ACCOMODATION_LIKE_SEQ_GEN"
    )
    @Column(name = "accmodation_like_no")
    
    private int accmodationLikeNo;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "users_no", foreignKey = @ForeignKey(name = "fk_accom_like_to_users"))
    private Users users;
  
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "accomodation_no", foreignKey = @ForeignKey(name = "fk_accom_like_to_accom"))
    private Accomodation accomodation;

}
