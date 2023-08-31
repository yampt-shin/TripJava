package com.example.demo.entity;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Table(name = "users")
@SequenceGenerator(
        name="USERS_SEQ_GEN",
        sequenceName = "USERS_SEQ",
    	initialValue = 1,
    	allocationSize = 1
)
@Builder
public class Users {
    @Id
    @GeneratedValue(
		strategy =  GenerationType.SEQUENCE,
		generator = "USERS_SEQ_GEN"
    )
    @Column(name = "users_no")
    private int usersNo;
    @Column(name = "users_id")
    private String usersId;
    @Column(name = "users_password")
    private String usersPassword;
    @Column(name = "users_name")
    private String usersName;
    @Column(name = "users_fname")
    private String usersFname;
	//테이블 매핑에서는 제외 시켜라!
	@Transient
	private MultipartFile uploadFile;
    @Column(name = "users_phone")
    private String usersPhone;
    @Column(name = "users_date")
    private Date usersDate;
    @PrePersist
    public void prePersist() {
        this.usersDate = new Date();
    }
	public Users(int usersNo, String usersId, String usersPassword, String usersName, String usersFname,
			MultipartFile uploadFile, String usersPhone, Date usersDate) {
		super();
		this.usersNo = usersNo;
		this.usersId = usersId;
		this.usersPassword = usersPassword;
		this.usersName = usersName;
		this.usersFname = usersFname;
		this.uploadFile = uploadFile;
		this.usersPhone = usersPhone;
		this.usersDate = usersDate;
	}
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
    
} 
