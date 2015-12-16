package org.tuui.email;

import lombok.extern.slf4j.Slf4j;
import org.omg.CORBA.Object;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("email")
public class EmailRestController {

	private final String QUEUE_NAME = "email.queue";

	@Autowired
	private JmsTemplate jmsTemplate;

	@RequestMapping(method = RequestMethod.GET)
	public void sendTestMessage() {
		log.debug("sendTestMessage......");

		Map map = new HashMap<String, Object>();
		map.put("email", "test@test.com");
		map.put("message", "tere");

		jmsTemplate.convertAndSend(QUEUE_NAME, map);
	}
}
