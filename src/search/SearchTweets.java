package search;

import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

import java.util.List;

/**
 * @author Yusuke Yamamoto - yusuke at mac.com
 * @since Twitter4J 2.1.7
 */
public class SearchTweets {
    /**
     * Usage: java twitter4j.examples.search.SearchTweets [query]
     *
     * @param args search query
     */
    public static void main(String[] args) {
    	ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
              .setOAuthConsumerKey("1oUazsxLrYqK82o4VVhABXYhK")
              .setOAuthConsumerSecret("aguBdxqMb2RQlISQzBLdkwJNv1TGWtYPUAeucg49MkntkcFSAo")
              .setOAuthAccessToken("788725938209091584-RrG1yPWdlvOe8rD9OqJgNg1JrbIDw78")
              .setOAuthAccessTokenSecret("Xd2vPKQ4KYH1eWHjBimUVp0Ytxhk5D8QBfLhJ66s8ih3l");
    	TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = tf.getInstance();
        try {
        	Query query = new Query("sarkozy");
        	QueryResult result;
        	result = twitter.search(query);
        	List<Status> tweets = result.getTweets();
        	for (Status tweet : tweets) {
        		System.out.println("@" + tweet.getUser().getScreenName() + " - " + tweet.getText());
        	}

        	System.exit(0);
        } catch (TwitterException te) {
        	te.printStackTrace();
        	System.out.println("Failed to search tweets: " + te.getMessage());
        	System.exit(-1);
        }
    }
    
}