package com.galan.springwebsocket.scheduler;

import com.galan.springwebsocket.pojos.Numeros;
import com.galan.springwebsocket.utility.DataFake;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@EnableScheduling
@Configuration
public class SocketScheduler {

    @Autowired
    private SimpMessageSendingOperations webSocket;

    @Scheduled(fixedDelay = 5000)
    public void aleatorio() {
        System.out.println("dentro del scheduled");
        Numeros numeros = new Numeros(DataFake.getFAKER().random().nextInt(1000, 3256));
        System.out.println(numeros.getNumero());

        webSocket.convertAndSend("/numero/aleatorio", numeros);
        Numeros numeros2 = new Numeros(DataFake.getFAKER().random().nextInt(0, 600));
        System.out.println(numeros2.getNumero());

        webSocket.convertAndSend("/numero/aleatorio2", numeros2);
    }

}
