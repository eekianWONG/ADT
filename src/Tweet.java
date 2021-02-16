import java.util.Date;

/**
 * example taken from http://web.mit.edu/6.005/www/fa15/classes/13-abstraction-functions-rep-invariants/
 * This immutable data type represents a tweet from Twitter.
 */
public class Tweet {

    private String author;
    private String text;
    private Date timestamp;

    /**
     * Make a Tweet.
     * @param author    Twitter user who wrote the tweet.
     * @param text      text of the tweet
     * @param timestamp date/time when the tweet was sent
     */
    public Tweet(String author, String text, Date timestamp) {
        this.author = author;
        this.text = text;
        this.timestamp = timestamp;
    }
    
    /** @return Twitter user who wrote the tweet */
    public String getAuthor() {
        return author;
    }

    /** @return text of the tweet */
    public String getText() {
        return text;
    }

    /** @return date/time when the tweet was sent */
    public Date getTimestamp() {
        return timestamp;
    }
    
    /** @return a tweet that retweets t, one hour later*/
    public static Tweet retweetLater(Tweet t) {
        Date d = t.getTimestamp();
        //d.setHours(d.getHours()+1); // this line changes original Tweet timestamp
        // Date is mutable
        Date newD = new Date();
        newD.setHours(d.getHours()+1);
        return new Tweet("rbmllr", t.getText(), newD);
    }
    
    public String print() {
        return this.author + " " + this.timestamp;
    }
    
    public static void main(String[] args) {
        
        Tweet t = new Tweet("justinbieber", 
                    "Thanks to all those beliebers out there inspiring me every day", 
                    new Date());
        System.out.println("original tweet");
        System.out.println(t.print());
        
        System.out.println("re-tweet");
        Tweet newT = Tweet.retweetLater(t);
        System.out.println(newT.print());
        
        System.out.println(t.print());
    } 
}

/*
public Date getTimestamp() {
    return new Date(Date.getTime());
}
*/
