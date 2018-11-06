package com.java;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQTextMessage;

public class MyPublisher {

	public static void main(String args[]) throws JMSException {
		ConnectionFactory factory= new ActiveMQConnectionFactory("tcp://dell-PC:61616");
		Connection connection=factory.createConnection();
		Session session=connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Destination queue=session.createQueue("Queue1");
		MessageProducer producer=session.createProducer(queue);
		TextMessage message= new ActiveMQTextMessage();
		message.setText("Hello World!");
		producer.send(message);
		session.close();
		connection.close();
	}
}
