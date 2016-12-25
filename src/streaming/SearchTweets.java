package streaming;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import twitter4j.FilterQuery;
import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;
import twitter4j.TwitterException;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.auth.AccessToken;

public class SearchTweets {
	
	static int count = 0;
	static List<String> tweets = new ArrayList<String>();
	
	public static void main(String[] args) throws TwitterException, IOException {
		
		TwitterStream twitterStream = new TwitterStreamFactory().getInstance();
		
		StatusListener listener = new StatusListener() {
	        
			public void onStatus(Status status) {
				if (count < 1000) {
					if (!status.isRetweet()) {
						String tweet = status.getText();
						tweet = tweet.replaceAll("[\r\n]+", " ");
						System.out.println(tweet);
						count++;
					}
				}
				else {
					twitterStream.removeListener(this);
					System.exit(0);
					return;
				}
	        }
			
	        public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) {}
	        
	        public void onTrackLimitationNotice(int numberOfLimitedStatuses) {}
	        
	        public void onException(Exception ex) {
	            ex.printStackTrace();
	        }
	        
			@Override
			public void onScrubGeo(long arg0, long arg1) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void onStallWarning(StallWarning arg0) {
				// TODO Auto-generated method stub
				
			}
	    };
	    
	    twitterStream.addListener(listener);
	    twitterStream.setOAuthConsumer("1oUazsxLrYqK82o4VVhABXYhK", "aguBdxqMb2RQlISQzBLdkwJNv1TGWtYPUAeucg49MkntkcFSAo");
	    twitterStream.setOAuthAccessToken(new AccessToken("788725938209091584-RrG1yPWdlvOe8rD9OqJgNg1JrbIDw78", "Xd2vPKQ4KYH1eWHjBimUVp0Ytxhk5D8QBfLhJ66s8ih3l"));
	    
	    String[] lang = {"fr"};
	    FilterQuery filter = new FilterQuery();
	    filter.track("France");
	    filter.language(lang);
	    twitterStream.filter(filter);    
	}
	
}