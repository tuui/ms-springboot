package org.tuui.email;

import java.io.Serializable;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class EmailListener {

	private final String QUEUE_NAME = "email.queue";

	@Autowired
	private EmailService emailService;

	@JmsListener(destination = QUEUE_NAME)
	public void receiveMessage(Map map) {
		log.debug("receiveMessage = {}", map.get("email"));
		emailService.addEmail(new EmailService.Email((String) map.get("email"), (String) map.get("message")));
	}

	@Data
	@AllArgsConstructor
	public static class TestMsg implements Serializable {
		private Long id;
		private String message;
	}
}
