package com.example.demo.admin.util;

import java.util.List;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

import com.example.demo.admin.repository.AdminUsersRepository;
import com.example.demo.entity.Users;
import com.sist.util.admin.MyUtil;

import lombok.Setter;

@Component
@EnableScheduling
@Setter
public class SendMail {
	@Autowired
	private AdminUsersRepository ur;
	
	@Autowired
	private MailSender mailSender;
	
	@Autowired
	private JavaMailSender sender;
	
	
					 //초 분 시간 일 월 요일 연도
//	@Scheduled(cron = "20 46 14 5 * ?")
	public void sendHtml() {
		List<Users> list = ur.findAll();
		for(Users u:list) {
			String from = "ojo228412@gmail.com";
			String to = u.getUsersId();
			String data = MyUtil.getHtml(u);
			sender.send(new MimeMessagePreparator() {
				
				@Override
				public void prepare(MimeMessage mimeMessage) throws Exception {
					// TODO Auto-generated method stub
					MimeMessageHelper message = 
							new MimeMessageHelper(mimeMessage, "UTF-8");
					message.setFrom(from);
					message.setTo(to);
					message.setSubject(u.getUsersName()+"님 안녕하십니까 트립자바입니다.[담당자 : 임준열]");
					message.setText(data, true);
				}
			});
			
			System.out.println(u.getUsersName()+"("+ to +")님에게 메일을 발송하였습니다.");
		}
	}
		
//		public void send() {
//			List<Users> list = ur.findAll();
//			for(Users u:list) {
//				String to = u.getUsersId();
//				String title = "아으"+u.getUsersName()+"시치 [담당자 : 임준열]";
//				String data = "이번달 트립자바 이벤트 행사중입니다.";
//				
//				SimpleMailMessage mailMessage = 
//						new SimpleMailMessage();
//				mailMessage.setFrom("ojo228412@gmail.com");
//				mailMessage.setTo(to);
//				mailMessage.setSubject(title);
//				mailMessage.setText(data);
//				
//				mailSender.send(mailMessage);
//				
//			}
//		}
}