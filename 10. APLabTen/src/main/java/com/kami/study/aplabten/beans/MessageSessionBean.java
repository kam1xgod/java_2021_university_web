package com.kami.study.aplabten.beans;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@Startup
@Singleton(name = "MessageSessionBean")
@LocalBean
public class MessageSessionBean implements HttpSessionListener {

    private static int counter = 0;

    public void sessionCreated(HttpSessionEvent event) {
        counter++;
    }

    public void sessionDestroyed(HttpSessionEvent event) {
        counter--;
    }

    public static int getActiveSessionCount() {
        return counter;
    }
}
