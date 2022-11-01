package hytte.restapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import hytte.core.PostList;
import hytte.json.PostModule;
import hytte.ui.HytteRead;
import hytte.ui.HytteSave;

//makes the spring server respong to GET and POST requests
@RestController
@RequestMapping(RestAppController.CONTROLLER_PATH)
public class RestAppController {

    public final static String CONTROLLER_PATH = "/hytte";
    

    /**
     * Method for handling GET-request to the rest server.
     * @return Json representation of the PostList object stored on the rest server side.
     * @throws JsonProcessingException
     */
    @GetMapping
    public String getPostList() throws JsonProcessingException{
        HytteRead hytteReader = new HytteRead();
        PostList postList = hytteReader.read("hyttebok.json");
        
        ObjectMapper om = new ObjectMapper();
        om.registerModule(new PostModule());
        String jsonPostList = om.writeValueAsString(postList);

        System.out.println("GET request received");

        return jsonPostList;
    }

    /**
     * Method for handling POST-requests to the rest server.
     * @param postedPostList Json serialized PostList object.
     * @return True if the serialized PostList was successfully received and store.
     * @throws Exception
     */
    @PostMapping
    public boolean postData(@RequestBody String postedPostList) throws Exception{
        HytteSave hytteSaver = new HytteSave();
        ObjectMapper om = new ObjectMapper();
        om.registerModule(new PostModule());
        try {
            PostList deserealizedPostList = om.readValue(postedPostList, PostList.class);
            hytteSaver.commitSave(deserealizedPostList, "hyttebok.json");
            System.out.println("POST successful from RestAppController");
            return true;
        } catch (Exception e) {
            throw new Exception("Failed to save postList");
        }
    }
}
