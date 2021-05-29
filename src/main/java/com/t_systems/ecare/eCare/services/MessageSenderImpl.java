package com.t_systems.ecare.eCare.services;

import javax.annotation.Resource;
import javax.jms.*;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class MessageSenderImpl implements MessageSender {



/*    @Resource(lookup = "java:/eCare/MyConnectionFactory")
    private ConnectionFactory connectionFactory;
    @Resource(lookup = "java:/eCare/myQueue")
    private Destination destination;
    private static final long TIME_TO_LIVE_MILLISEC = 30_000; //messages older than that value won't be delivered to destination

    @Override
    public void sendMessage(String json) {
        try (
                QueueConnection connection = (QueueConnection) connectionFactory.createConnection();
                QueueSession session = connection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
                MessageProducer producer = session.createProducer(destination)
        ) {

            TextMessage message = session.createTextMessage(json);
            producer.setTimeToLive(TIME_TO_LIVE_MILLISEC);
            producer.send(message);
            Logger.getLogger(MessageSenderImpl.class).info("Send jms:" + json);

        } catch (JMSException ex) {
            Logger.getLogger(MessageSenderImpl.class).error(ex.getMessage(), ex);
        }
    }*/

    @Autowired
    @Qualifier("jmsQueueTemplate")
    private JmsTemplate jmsTemplate;

    public void sendMessage(String json) {
       // MessageCreator messageCreator = session -> session.createTextMessage(json);
        MessageCreator messageCreator = session -> session.createTextMessage("update");
        jmsTemplate.send(messageCreator);
    }



}
