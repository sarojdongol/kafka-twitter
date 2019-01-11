package com.sarojdongol.kafka.yahoofinance;


import twitter4j.*;
import java.util.logging.Logger;

public   class TwitterHashFetcher {

    private static Logger LOG = Logger.getLogger(TwitterHashFetcher.class.getName());

    TwitterStream twitterStream = new TwitterStreamFactory().getInstance().addListener(new StatusListener() {
        @Override
        public void onStatus(Status status) {
            LOG.info("Streaming Twitter data");
        }
        @Override
        public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) {
        }

        @Override
        public void onTrackLimitationNotice(int numberOfLimitedStatuses) {
        }

        @Override
        public void onScrubGeo(long userId, long upToStatusId) {
        }

        @Override
        public void onStallWarning(StallWarning warning) {
        }
        @Override
        public void onException(Exception ex) {
            ex.printStackTrace();
        }
    }).sample();
}

