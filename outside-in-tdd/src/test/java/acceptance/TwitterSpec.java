package acceptance;

import com.codurance.twitter.InMemoryTweetRepository;
import com.codurance.twitter.Tweet;
import com.codurance.twitter.TweetValidator;
import com.codurance.twitter.TwitterEngine;
import org.junit.Before;

import java.util.List;

public abstract class TwitterSpec {

	static final String SANDRO = "sandromancuso";
	static final String SAMIR = "samirtalwar";
	static final String MASH = "mashooq";
	static final String STEVE = "tooky";
	static final String PEDRO = "pedromsantos";

	static final String SANDRO_FIRST_TWEET  = "Sandro first tweet";
	static final String SANDRO_SECOND_TWEET = "Sandro second tweet";
	static final String SAMIR_FIRST_TWEET   = "Samir first tweet";
	static final String SAMIR_SECOND_TWEET  = "Samir second tweet";
	static final String MASH_FIRST_TWEET    = "Mash first tweet";
	static final String STEVE_FIRST_TWEET   = "Steve first tweet";
	static final String STEVE_SECOND_TWEET  = "Steve second tweet";
	static final String PEDRO_FIRST_TWEET   = "Pedro first tweet";

	private TweetValidator tweetValidator;
	private TwitterEngine twitterEngine;
	private InMemoryTweetRepository inMemoryTweetRepository;

	@Before
	public void initialise() {
		tweetValidator = new TweetValidator();
		inMemoryTweetRepository = new InMemoryTweetRepository();
		twitterEngine = new TwitterEngine(tweetValidator, inMemoryTweetRepository);
	}

	void post(String twitterId, String tweet) {
		twitterEngine.post(twitterId, tweet);
	}

	List<Tweet> tweetsFrom(String twitterId) {
		return twitterEngine.tweetsFrom(twitterId);
	}

	List<Tweet> wallOf(String twitterId) {
		throw new UnsupportedOperationException();
	}

	void formerFollowsLatter(String twitterId, String twitterIdToBeFollowed) {
		throw new UnsupportedOperationException();
	}

}
