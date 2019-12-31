package me.youngsil;

import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class MyEventHandler {

    @EventListener
    @Async
    public void onApplicationEvent(MyEvent event) {
        System.out.println(Thread.currentThread().toString());
        System.out.println("이벤트 받았다. 데이터는 " +event.getData());
    }

    @EventListener
    public void handle(ContextRefreshedEvent event) {
        ApplicationContext v = event.getApplicationContext();
    }
}
