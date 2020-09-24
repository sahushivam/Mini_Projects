import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;

 

public class hello {
    public static void main(String args[]) throws IOException {
        URL urlForGetRequest = new URL("http://host.docker.internal:8050/v1/metadata/objects/scheduler/callback"); //in docker
       //URL urlForGetRequest = new URL("http://localhost:8050/v1/metadata/objects/scheduler/callback"); //outside docker
        String readLine = null;
        HttpURLConnection conection = (HttpURLConnection) urlForGetRequest.openConnection();
        conection.setRequestProperty("Authorization","Bearer "+"TACT_TEST_TOKEN");
        conection.setRequestProperty("Content-Type","application/json");
        conection.setRequestMethod("POST");
        int responseCode = conection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(conection.getInputStream()));
            StringBuffer response = new StringBuffer();
            while ((readLine = in .readLine()) != null) {
                response.append(readLine);
            } in .close();
            // print result
            System.out.println("JSON String Result " + response.toString());
            //GetAndPost.POSTRequest(response.toString());
        } else {
            System.out.println("GET NOT WORKED");
        }
    }
}