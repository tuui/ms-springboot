package org.tuui.email;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

	private static List<Email> emails = new ArrayList<>();
	private final String QUEUE_NAME = "email.queue";

	@Autowired
	private JmsTemplate jmsTemplate;

	@SuppressWarnings("unchecked")
	public void sendEmail(Email email) {
		Map map = new HashMap<String, String>();
		map.put("email", email.getAddress());
		map.put("message", email.getMessage());

		jmsTemplate.convertAndSend(QUEUE_NAME, map);
	}

	public void addEmail(Email email) {
		emails.add(email);
	}

	public List<Email> getEmails() {
		return emails;
	}

	@Data
	@AllArgsConstructor
	public static class Email {
		private String address;
		private String message;
	}
}
