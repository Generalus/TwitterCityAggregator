import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

public class Aggregator {

    public static void main(String[] args){

        ConfigurationBuilder config = new twitter4j.conf.ConfigurationBuilder()
                                                 .setOAuthConsumerKey("cOspurp8cRbwkIt4UmJxFM7CQ")
                                                 .setOAuthConsumerSecret("3NjPnajPn7qfR5cxgM5r01GKFD4k5d3lkdTjkCgSJLYtiSr2xZ")
                                                 .setOAuthAccessToken("905372999314001920-YsaUI6NrnoM0Xcf8pUoWMvfPrM7lzgc")
                                                 .setOAuthAccessTokenSecret("NWLgXc7RJjagEsjrcQxp9iuNu0MYIQirdCZ88Tq7YaNBb");
        StatusListener statusListener = new StatusListener() {

            public void onStatus(Status status) {

                System.out.println("@" + status.getUser().getName() + "---" + status.getText());
            }

            public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) {

            }

            public void onTrackLimitationNotice(int i) {

            }

            public void onScrubGeo(long l, long l1) {

            }

            public void onStallWarning(StallWarning stallWarning) {

            }

            public void onException(Exception e) {

            }
        };

        TwitterStream twitterStream = new TwitterStreamFactory(config.build()).getInstance();

        twitterStream.addListener(statusListener);

        long[] cnnId = {759251};

        FilterQuery cnnQuery = new FilterQuery(cnnId);

        twitterStream.filter(cnnQuery);
    }
}
