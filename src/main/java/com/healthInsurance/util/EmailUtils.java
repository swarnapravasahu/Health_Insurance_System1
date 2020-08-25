package com.healthInsurance.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.healthInsurance.model.RegisterModel;



@Component
public class EmailUtils {

	@Autowired
	private JavaMailSender javaMailSender;
	
	public boolean sendEmail(String to, String subject, String body) {
		try {
			SimpleMailMessage msg = new SimpleMailMessage();
			msg.setTo(to);
			msg.setSubject(subject);
			msg.setText(body);
			
			javaMailSender.send(msg);
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

public boolean sendEmailNew(String to, String subject, String body,RegisterModel register) {
		try {

			MimeMessage mimeMsg = javaMailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(mimeMsg);

			helper.setTo(to);
			helper.setSubject(subject);
			
			helper.setText(getUnlockAccEmailBody(register), true);
			
			javaMailSender.send(mimeMsg);

			return true;
		} catch (Exception e) {

		}
		return false;
	}


private String getUnlockAccEmailBody(RegisterModel register) throws IOException {
	StringBuffer sb = new StringBuffer("");

	FileReader fr = new FileReader("UNLOCK-ACC-EMAIL-BODY-TEMPLATE.txt");
	BufferedReader br = new BufferedReader(fr);
	String line = br.readLine();

	while (line != null) {
		sb.append(line);
		line = br.readLine();
	}
	
	br.close();

	// format mail body
	String mailBody = sb.toString();
	mailBody = mailBody.replace("{FNAME}", register.getFsName());
	mailBody = mailBody.replace("{LNAME}", register.getLsName());
	mailBody = mailBody.replace("{TEMP-PWD}", register.getPassword());
	mailBody = mailBody.replace("{EMAIL}", register.getEmailId());

	return mailBody;
}
}
