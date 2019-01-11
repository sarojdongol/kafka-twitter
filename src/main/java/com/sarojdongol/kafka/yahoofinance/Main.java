package com.sarojdongol.kafka.yahoofinance;

import java.util.logging.Logger;

public class Main {

    public static void main(String[] arg) {
        System.out.println("Main Thread starting...");
        Logger log = Logger.getLogger(Main.class.getName());

        KafkaMultiThreadProducer producerthread1 = new KafkaMultiThreadProducer();
        if(producerthread1.isAlive()){
        System.out.println("Thread producer 1 running");
        try {
        log.info("Sleeping the thread for 300 ms");
        Thread.sleep(30000);
        } catch (InterruptedException e) {
        e.printStackTrace();
        }
        }
        new KafkaMultiThreadProducer();


        System.out.println("Main Ending");
        }


    }
