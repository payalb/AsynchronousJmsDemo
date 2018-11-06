package com.java;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;

public class MyConsumer {
	public static void main(String[] args) throws JMSException, InterruptedException {
		ConnectionFactory factory= new ActiveMQConnectionFactory("tcp://dell-PC:61616");
		Connection connection=factory.createConnection();
		Session session=connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Destination queue=session.createQueue("Queue1");
		MessageConsumer consumer=session.createConsumer(queue);
		connection.start();
		
		consumer.setMessageListener(new MyMessageListener());
		Thread.sleep(7000);
	}
}

class MyMessageListener implements MessageListener{

	@Override
	public void onMessage(Message message) {
		System.out.println(message);
		
	}
}