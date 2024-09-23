package com.example.dto;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Employee {

    public void Create() {
        try (SessionFactory factory = new Configuration().configure("hibernate"))
    }
}

