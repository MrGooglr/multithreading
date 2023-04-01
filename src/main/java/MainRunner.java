import thread.URLStatusFinder;

import java.util.concurrent.*;

public class MainRunner {
    public static void main(String[] args) {

        String[] urlArray = {
                "https://crunchify.com",
                "https://yahoo.com",
                "https://www.ebay.com",
                "https://google.com",
                "https://www.example.co",
                "https://paypal.com",
                "http://bing.com/",
                "https://techcrunch.com/",
                "http://mashable.com/",
                "https://pro.crunchify.com/",
                "https://wordpress.com/",
                "https://wordpress.org/",
                "https://example.com/",
                "https://sjsu.edu/",
                "https://crunchify.com/",
                "https://test.com.au/",
                "https://www.wikipedia.org/",
                "https://en.wikipedia.org"
        };

        ExecutorService ex = Executors.newFixedThreadPool(10);

        try{
            for (String s : urlArray) {
                URLStatusFinder urlStatusFinder = new URLStatusFinder(s);
                ex.execute(urlStatusFinder);
            }
        }catch (Exception e){
            System.out.println("Exception : "+e.getMessage());
        }finally {
            ex.shutdown();
        }
    }
}
