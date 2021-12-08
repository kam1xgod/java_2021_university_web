package com.kami.study.aplabten.beans;

import entities.MessagesEntity;

import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.ejb.MessageDrivenContext;
import javax.ejb.Startup;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.persistence.*;
import javax.websocket.OnMessage;

@Startup
@MessageDriven(mappedName = "java:/jms/queue/ExpiryQueue", activationConfig = {
        @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge"),
        @ActivationConfigProperty(propertyName = "destination", propertyValue = "java:/jms/queue/ExpiryQueue"),
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class NewMessageBean implements MessageListener {
//    EntityTransaction transaction = entityManager.getTransaction();

//    @PersistenceContext(unitName = "default")
//    private EntityManager em;

    @Resource
    private MessageDrivenContext mdc;

    public void save(Object obj) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(obj);
        transaction.commit();
    }

    @Override
    @OnMessage
    public void onMessage(Message message) {
        ObjectMessage msg = null;
        try {
            if (message instanceof ObjectMessage) {
                msg = (ObjectMessage) message;
                MessagesEntity e = (MessagesEntity) msg.getObject();
                save(e);
            }
        } catch (Exception e) {
            e.printStackTrace();
            mdc.setRollbackOnly();
        }
    }
}
