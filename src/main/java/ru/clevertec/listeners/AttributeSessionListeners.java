package ru.clevertec.listeners;

import org.apache.log4j.Logger;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener
public class AttributeSessionListeners implements HttpSessionAttributeListener {
    private final Logger log = Logger.getLogger(AttributeSessionListeners.class);
    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        log.info("name: " + event.getName());
        log.info("value " + event.getValue());
    }
}
