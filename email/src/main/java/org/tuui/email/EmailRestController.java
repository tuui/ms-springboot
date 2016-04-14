package org.tuui.email;

import java.util.List;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("email")
public class EmailRestController {

	@Autowired
	private EmailService emailService;

	@RequestMapping(value = "/send", method = RequestMethod.GET)
	public void sendTestMessage() {
		log.debug("sendTestMessage......");
		emailService.sendEmail(new EmailService.Email("test@test.com", "testmessage"));
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<EmailService.Email> getRecievedMessages() {
		return emailService.getEmails();
	}
}
