package com.example.service1.event;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class UserEventListener {

    @EventListener
    public void handleUserCreatedEvent(UserCreatedEvent event) {
        System.out.println("User created: " + event.getUser().getUsername());
    }
}