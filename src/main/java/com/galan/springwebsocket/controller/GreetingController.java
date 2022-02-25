package com.galan.springwebsocket.controller;

import com.galan.springwebsocket.pojos.Greeting;
import com.galan.springwebsocket.pojos.HelloMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class GreetingController {

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greet(HelloMessage message) {
        System.out.println(message.getName());//imprimiendo el envio desde el cliente html
//        return new Greeting("hola, " + HtmlUtils.htmlEscape(message.getName()));
        return new Greeting(HtmlUtils.htmlEscape("hola " + message.getName().toUpperCase()) );
    }
}
