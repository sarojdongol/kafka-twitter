package com.sarojdongol.kafka.yahoofinance;


public class KafkaMultiThreadProducer  extends Thread {

    @Override
    public void run(){
        new KafkaSampleProducer();
    }

    public KafkaMultiThreadProducer(){
        this.start();

    }
}
