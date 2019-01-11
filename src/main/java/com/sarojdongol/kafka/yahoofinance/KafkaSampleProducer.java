package com.sarojdongol.kafka.yahoofinance;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import twitter4j.TwitterException;

import java.util.Properties;

public class KafkaSampleProducer {
    {
        Properties props = new Properties();
        props.put("bootstrap.servers", "18.234.25.131:9092");
        props.put("acks", "all");
        props.put("retries", 0);
        /*producers sends a batch of messages either when the current batch is full(batch.size) or when the
        linger.ms limit is reached.
         */
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        Producer<String, String> producer = new KafkaProducer<String, String>(props);


        try {
            producer.send(new ProducerRecord<String, String>("msk-mirror", "saroj", new TwitterHashFetcher().twitterStream.getScreenName()));
            producer.close();

        } catch (TwitterException e) {
            e.printStackTrace();
        }
        System.out.println("putting data");

        String threadName =  Thread.currentThread().getName();
        System.out.println("Message sent successfully" + " " + threadName);

        }


    }