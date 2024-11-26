package com.example.event;


import com.example.entity.Employee;
import org.springframework.context.ApplicationEvent;

public class UserCreatedEvent extends ApplicationEvent {

    private Employee employee;

    public UserCreatedEvent(Object source, Employee employee) {
        super(source);
        this.employee = employee;
    }

    public Employee getUser() {
        return employee;
    }
}