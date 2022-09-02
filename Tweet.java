// Name: AMAL JOHNSON
// ID: 21263175
public class Tweet
{
    // instance variables - replace the example below with your own

    private String postedBy;
    private String tweetText;

    private int hashtagCount;

    private int usernameCount;

    private long postedAt;

    private int symbol;

    private final int DEFAULT_DISPLAY_WIDTH = 30;

    private final int MINIMUM_DISPLAY_WIDTH = 1;

    private final int MAXIMUM_DISPLAY_WIDTH = 80;

    private final int MINIMUM_HEADER_WIDTH = 10;
    /**
     * Constructor for objects of class Tweet
     */

    public Tweet(String text)
    {
        tweetText = text;
        postedBy ="@" + System.getProperty("user.name");
        postedAt = System.currentTimeMillis(); 
        this.hashtagCount = count('#');
        this.usernameCount = count('@');
    }

    public String getPostedBy(){
        return postedBy;
    }

    public String gettweetText(){
        return tweetText;
    }

    public int gethashtagCount(){
        return hashtagCount;
    }

    public int getusernameCount(){
        return usernameCount;
    }

    public long getpostedAt(){
        return postedAt;
    }

    private int count(char symbol){
        int i, count = 0 ;
        for( i = 0 ; i < tweetText.length(); i = i + 1 ) {
            if(tweetText.charAt(i) == symbol ) {
                count = count + 1;
            }
        }
        return count;
    }

    public String postedAtTime(){
        final long MILLISECONDS_IN_A_DAY = 24*60*60*1000 ;
        final long SECONDS_IN_AN_HOUR = 60*60 ;

        // Declaring some variables (strictly speaking "named variables")
        long millisSinceMidnight = 0, secondsSinceMidnight = 0 ;
        long hour = 0, minute = 0, second = 0 ;

        // Take the current time and remove all the time up to midnight last night 
        millisSinceMidnight = postedAt % MILLISECONDS_IN_A_DAY;
        // Convert the millis to seconds
        secondsSinceMidnight = millisSinceMidnight / 1000;
        // Calculate how many hours are in secondsSinceMidnight
        hour = secondsSinceMidnight / SECONDS_IN_AN_HOUR;
        // Calculate how many minutes are in time NOT INCLUDED in the hours
        minute = (secondsSinceMidnight % SECONDS_IN_AN_HOUR) / 60;
        // Calculate how many seconds are in time NOT INCLUDED in the hours and minutes
        second = secondsSinceMidnight % 60;
        return String.format ("%02d:%02d:%02d", hour, minute, second);

    }

    public int timeInSeconds(int hour, int minute, int second){
        int timeinSeconds = second;
        timeinSeconds = timeinSeconds + (hour * 3600);
        timeinSeconds = timeinSeconds + (minute * 60);
        if (hour <0 || hour >23){
            return -1;
        } else if (minute <0 || minute>59){
            return -1;
        } else if (second <0 || second >59){
            return -1;
        } else return timeinSeconds;

    }

    public char activityIndicator(){
        final long MILLISECONDS_IN_A_DAY = 24*60*60*1000 ;
        final long SECONDS_IN_AN_HOUR = 60*60 ;

        // Declaring some variables (strictly speaking "named variables")
        long millisSinceMidnight = 0, secondsSinceMidnight = 0 ;
        long hour = 0, minute = 0, second = 0 ;

        // Take the current time and remove all the time up to midnight last night 
        millisSinceMidnight = postedAt % MILLISECONDS_IN_A_DAY;
        // Convert the millis to seconds
        secondsSinceMidnight = millisSinceMidnight / 1000;
        // Calculate how many hours are in secondsSinceMidnight
        hour = secondsSinceMidnight / SECONDS_IN_AN_HOUR;
        if (hour >= 06 && hour < 12){
            return 'M';
        }else if (hour >= 12 && hour < 17){
            return 'A';
        } else if (hour >= 17 && hour < 22){
            return 'E';
        } else return 'N';
    }

    public boolean containsWord(String aWord){
        /* My solution I submitted for the assignment for which I was awarded 3/10:   
        String[] containsWord = this.tweetText.split(" ");
        for(int i = 0; i < containsWord.length; i++){
        if (containsWord[i].equals(aWord)){
        return true;
        }
        } return false;
        } */
        
        
        
        //The solution I came up with after going through the sample solution given by the instructor:
        boolean hasWord = false;
        String tweetCopy = tweetText.toLowerCase();
        aWord = aWord.toLowerCase();
        int startPos = tweetCopy.indexOf(aWord);
        while(startPos != -1 && hasWord == false){
            boolean noLetterBefore = true;
            int posBefore = startPos - 1;
            if(posBefore >= 0){
                noLetterBefore = !Character.isLetter(tweetText.charAt(posBefore));

            }
            boolean noLetterAfter = true;
            int posAfter = startPos + aWord.length();
            if(posAfter < tweetCopy.length()){
                noLetterAfter = !Character.isLetter(tweetText.charAt(posAfter));
            }
            if(noLetterBefore && noLetterAfter){
                hasWord = true;
            } else {
                startPos = tweetCopy.indexOf(aWord, posAfter);
            }
        }

        return hasWord;
    }
}