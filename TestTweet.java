// Name: AMAL JOHNSON
// ID: 21263175
public class TestTweet
{
    public static void main(String args[]){
        Tweet tweet1 = new Tweet ("Christ, the Saviour is born! #Christmas2k21 @Santa");
        Tweet tweet2 = new Tweet ("Hope to see the back of COVID-19 in 2022. #pandemic");
        Tweet tweet3 = new Tweet ("Can't wait for the next season of The Crown! @Netflix");
        System.out.println("Tweet: " + tweet2.gettweetText());
        System.out.println("Posted by " + tweet2.getPostedBy());
        System.out.println("Posted at: " + tweet2.postedAtTime());
        System.out.println("Posted at (in seconds) " + tweet2.timeInSeconds(20, 8, 32) + " seconds.");
        System.out.println("Number of Hashtags: " + tweet2.gethashtagCount());
        System.out.println("Number of Usernames: " + tweet1.getusernameCount());
        System.out.println();
        char timeFrame = tweet1.activityIndicator();
        if (timeFrame == 'M'){
            System.out.println("Good Morning!");
        }else if (timeFrame == 'A'){
            System.out.println("Good Afternoon!");
        } else if (timeFrame == 'E'){
            System.out.println("Good Evening!");
        } else {
            System.out.println("Good Night!");
        }
        System.out.println();
        System.out.println(tweet1.containsWord("born"));
        System.out.println();
        if (tweet1.containsWord("born") == true){
            System.out.println("Happy Birthday!");
        }else {
            System.out.println("Oops!");
        }
        if (tweet2.containsWord("COVID")==true){
            System.out.println("Covid-19 detected!");
        }else {
            System.out.println("Covid-19 not detected.");
        }
        if (tweet3.containsWord("sea")==true){
            System.out.println("Let's go surfing!");
        }else {
            System.out.println("Let's go for a walk.");
        }
    }
}