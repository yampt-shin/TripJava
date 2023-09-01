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
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "accomodation_info")
@SequenceGenerator(
        name="ACCOMODATION_INFO_SEQ_GEN",
        sequenceName = "ACCOMODATION_INFO_SEQ",
    	initialValue = 1,
    	allocationSize = 1
)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AccomodationInfo {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "ACCOMODATION_INFO_SEQ_GEN"
    )
    @Column(name = "accomodation_info_no")
    private int accomodationInfoNo;
    @Column(name = "accomodation_info_minPerson")
    private int accomodationInfoMinPerson;
    @Column(name = "accomodation_info_maxPersion")
    private int accomodationInfoMaxPersion;
    @Column(name = "accomodation_info_size")
    private int accomodationInfoSize;
    @Column(name = "accomodation_info_explanation")
    private String accomodationInfoExplanation;
    @Column(name = "accomodation_priceper_person")
    private String accomodationPriceperPerson;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "accomodation_no", foreignKey = @ForeignKey(name = "fk_accom_info_to_accom"))
    private Accomodation accomodation;


}
