package com.kami.study.aplabten.beans;

import entities.MessagesEntity;

import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Startup;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Startup
@Stateless
@LocalBean
public class MessageEntityFacade extends AbstractFacade<MessagesEntity>{

    @PersistenceContext(unitName = "default")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MessageEntityFacade() {
        super(MessagesEntity.class);
    }
}
