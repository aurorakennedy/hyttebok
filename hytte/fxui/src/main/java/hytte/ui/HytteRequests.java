package hytte.ui;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest.BodyPublishers;

import com.fasterxml.jackson.databind.ObjectMapper;

import hytte.core.PostList;
import hytte.json.PostModule;

//sends GET and POST requests to Spring-server
public class HytteRequests {
    

    //Method for sending POST-requests to Spring-server
    public Boolean postRequest(PostList postList) throws MalformedURLException, Exception{
        URI uri = new URI("http://localhost:8080/hytte");
        ObjectMapper om = new ObjectMapper();
        om.registerModule(new PostModule()); //register custom serializer
        String jsonPostList = om.writeValueAsString(postList); //serializes postList into Json
        
        final HttpRequest request = HttpRequest.newBuilder(uri).header("Accept", "application/json")
        .header("Content-Type", "application/json").POST(BodyPublishers.ofString(jsonPostList)).build(); //creates a Http POST-request with serialized postList as payload

        final HttpResponse<String> response = HttpClient.newBuilder().build().send(request, HttpResponse.BodyHandlers.ofString()); //sends the HttpRequest
        
        try {
            ObjectMapper om2 = new ObjectMapper();
            Boolean trueResponse = om2.readValue(response.body(), Boolean.class); //reads the response from rest server
            
            if (trueResponse != null && trueResponse){ 
                System.out.println("POST successful from HytteRequest");
                return true;
            }
            return false;
            
        } catch (Exception e) {
            throw new Exception("Could not POST to server. Probably not running");
        }   
    }

    //Method for sending GET-request to rest server. 
    public PostList getRequest() throws URISyntaxException, IOException, InterruptedException{
        URI uri = new URI("http://localhost:8080/hytte");
        HttpRequest request = HttpRequest.newBuilder(uri).header("Accept", "application/json").GET().build(); //GET request
        HttpResponse<String> response = HttpClient.newBuilder().build().send(request, HttpResponse.BodyHandlers.ofString()); //Response to GET request

        String postListString = response.body().toString(); //received PostList in string format
        System.out.println("Get-string: " + postListString);

        ObjectMapper om = new ObjectMapper();
        om.registerModule(new PostModule());
        PostList receivedPostList = om.readValue(postListString, PostList.class); //deserealization of received String

        return receivedPostList;
    }
}
