package org.tuui.email;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EmailApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmailApplication.class, args);
	}

/*	//	The CachingConnectionFactory is meant to wrap a JMS provider's connection to provide caching of sessions,
	// connections and producers as well as automatic connection recovery. By default, it uses a single session to create many connections
	@Bean
	ConnectionFactory connectionFactory() {
		return new CachingConnectionFactory(
				new ActiveMQConnectionFactory());
	}

	@Bean
	public MarshallingMessageConverter converter() {
		MarshallingMessageConverter converter = new MarshallingMessageConverter();
		Jaxb2Marshaller jaxbMarshaller = new Jaxb2Marshaller ();
		jaxbMarshaller.setPackagesToScan("org.tuui");
		converter.setUnmarshaller(jaxbMarshaller);
		converter.setMarshaller(jaxbMarshaller);
		return converter;
	}

	@Bean
	public JmsListenerContainerFactory jmsListenerContainerFactory(ConnectionFactory cf) {
		DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
		factory.setConnectionFactory(cf);
		factory.setMessageConverter(converter());
		return factory;
	}
*/
}
