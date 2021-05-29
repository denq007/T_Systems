package com.t_systems.ecare.eCare.services;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.*;
@Service
public class MessageSenderImpl implements MessageSender{

    private static final long TIME_TO_LIVE_MILLISEC = 30_000; //messages older than that value won't be delivered to destination

    @Resource(lookup = "java:/eCare/MyConnectionFactory")
    private ConnectionFactory connectionFactory;

    @Resource(lookup = "java:/eCare/MyQueue")
    private Destination destination;

    /**
     * Send message to JMS queue
     *
     * @param json message content in json formatted String
     */
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
    }
}
