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
@Table(name = "accomodation_rv")
@SequenceGenerator(
        name="ACCOMODATION_RV_SEQ_GEN",
        sequenceName = "ACCOMODATION_RV_SEQ",
    	initialValue = 1,
    	allocationSize = 1
)
@EntityListeners(AuditingEntityListener.class)
public class AccomodationRV {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "ACCOMODATION_RV_SEQ_GEN"
    )
    @Column(name = "ACCOMODATION_RV_NO")
    private int  accomodationRVNo;
    @Column(name = "accomodation_rv_checkin")
    private LocalDate accomodationRVCheckIn;
    @Column(name = "accomodation_rv_checkout")
    private LocalDate  accomodationRVCheckOut;
    
    @LastModifiedDate
    @Temporal(TemporalType.DATE)
    @Column(name = "accomodation_rv_date")
    private LocalDate accomodationRVDate;
    @Column(name = "accomodation_rv_Name")
    private String accomodationRVName;
    @Column(name = "accomodation_rv_People")
    private String accomodationRVPeople;
    @Column(name = "accomodation_RV_Phone")
    private String accomodationRVPhone;
    
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "users_no", foreignKey = @ForeignKey(name = "fk_accom_rv_to_users"))
    private Users users;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "accomodation_no", foreignKey = @ForeignKey(name = "fk_accom_rv_to_accom"))
    private Accomodation accomodation;

	
	public AccomodationRV(int accomodationRVNo, LocalDate accomodationRVCheckIn, LocalDate accomodationRVCheckOut,
			LocalDate accomodationRVDate, String accomodationRVName, String accomodationRVPeople,
			String accomodationRVPhone, Users users, Accomodation accomodation) {
		super();
		this.accomodationRVNo = accomodationRVNo;
		this.accomodationRVCheckIn = accomodationRVCheckIn;
		this.accomodationRVCheckOut = accomodationRVCheckOut;
		this.accomodationRVDate = accomodationRVDate;
		this.accomodationRVName = accomodationRVName;
		this.accomodationRVPeople = accomodationRVPeople;
		this.accomodationRVPhone = accomodationRVPhone;
		this.users = users;
		this.accomodation = accomodation;
	}
	@Override
	public String toString() {
		return "AccomodationRV [accomodationRVNo=" + accomodationRVNo + ", accomodationRVCheckIn="
				+ accomodationRVCheckIn + ", accomodationRVCheckOut=" + accomodationRVCheckOut + ", accomodationRVDate="
				+ accomodationRVDate + ", accomodationRVName=" + accomodationRVName + ", accomodationRVPeople="
				+ accomodationRVPeople + ", accomodationRVPhone=" + accomodationRVPhone + ", users=" + users
				+ ", accomodation=" + accomodation + "]";
	}
    
}
