package org.tuui.email;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Map;

@Slf4j
@Component
public class EmailListener {

	private final String QUEUE_NAME = "email.queue";

	@JmsListener(destination = QUEUE_NAME)
	public void receiveMessage(Map map) {
		log.debug("receiveMessage = {}", map.get("email"));
	}

	@Data
	@AllArgsConstructor
	public static class TestMsg implements Serializable {
		private Long id;
		private String message;
	}
}
