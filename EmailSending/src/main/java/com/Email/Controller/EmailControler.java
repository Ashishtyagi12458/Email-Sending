package com.Email.Controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.Email.Model.EmailRequest;
import com.Email.Model.EmailResponce;
import com.Email.Service.EmailService;


@RestController
public class EmailControler {
	@Autowired
	private EmailService emailService;
	

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/sendmail")
	public ResponseEntity<?> sendEmail(@RequestBody EmailRequest request){
		
		boolean result=this.emailService.sendEmail(
				request.getTo(),
				request.getSubject(),
				request.getMessage());
		if(result) {
			
			EmailResponce res=new EmailResponce(null);
			
			res.setToken("Email sent successfully..");
			return ResponseEntity.ok(res);

			
		}else {
			 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Email not send...");
		}
		
	}

}
