package com.backend.graphic.Graphic.Service;

// regra de negocio, logica
// controller, só recebe a requisicao, mas passa pra service fazer o trabalho

import org.springframework.stereotype.Service;

@Service
public class HelloWorldService {
    public String helloWorld(String name) {
        return "Hello World " + name;
    }
}
