package thread;

import java.net.HttpURLConnection;
import java.net.URL;

public class URLStatusFinder implements Runnable{

    private final String url;

    public URLStatusFinder(String url){
        this.url = url;
    }


    @Override
    public void run() {
        String result = "";
        int code = 200;
        try {
            URL siteURL = new URL(url);

            // HttpURLConnection: A URLConnection with support for HTTP-specific features. See the spec for details.

            // openConnection(): Returns a URLConnection instance that represents a connection to the remote object referred to by the URL.
            HttpURLConnection connection = (HttpURLConnection) siteURL.openConnection();

            // setRequestMethod: Set the method for the URL request, one of:
            //GET
            //POST
            //HEAD
            //OPTIONS
            //PUT
            //DELETE
            //TRACE
            connection.setRequestMethod("GET");

            // setConnectTimeout(): Sets a specified timeout value, in milliseconds, to be used when opening a communications link to the resource referenced by this URLConnection.
            // If the timeout expires before the connection can be established, a java.net
            connection.setConnectTimeout(3000);

            // connect(): Opens a communications link to the resource referenced by this URL, if such a connection has not already been established.
            connection.connect();

            // getResponseCode(): Gets the status code from an HTTP response message. For example, in the case of the following status lines:
            //       HTTP/1.0 200 OK
            //       HTTP/1.0 401 Unauthorized
            code = connection.getResponseCode();
            if (code == 200) {
                result = "-> Green <-\t\t" + "Code: " + code;
                ;
            } else {
                result = "-> Yellow <-\t\t" + "Code: " + code;
            }
        } catch (Exception e) {
            result = "-> Red <-\t\t" + "Wrong domain - Exception: " + e.getMessage();

        }
        System.out.println(url + "\t\t\t\tStatus:" + result);
    }
}
