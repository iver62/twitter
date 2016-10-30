package streaming;

import java.io.IOException;

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

	public static void main(String[] args) throws TwitterException, IOException {
	    
		StatusListener listener = new StatusListener() {
	        
			public void onStatus(Status status) {
	            System.out.println(status.getUser().getName() + " : " + status.getText());
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
	    
	    TwitterStream twitterStream = new TwitterStreamFactory().getInstance();
	    twitterStream.addListener(listener);
	    twitterStream.setOAuthConsumer("1oUazsxLrYqK82o4VVhABXYhK", "aguBdxqMb2RQlISQzBLdkwJNv1TGWtYPUAeucg49MkntkcFSAo");
	    twitterStream.setOAuthAccessToken(new AccessToken("788725938209091584-RrG1yPWdlvOe8rD9OqJgNg1JrbIDw78", "Xd2vPKQ4KYH1eWHjBimUVp0Ytxhk5D8QBfLhJ66s8ih3l"));
	    
	    FilterQuery filter = new FilterQuery();
//	    filter.language(new String[] { "fr" });
	    filter.track("daech");
	    // sample() method internally creates a thread which manipulates TwitterStream and calls these adequate listener methods continuously.
//	    twitterStream.sample();
	    twitterStream.filter(filter);
	}
	
}