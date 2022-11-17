package hytte.restapi;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.time.LocalDate;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import hytte.core.Post;
import hytte.core.PostList;
import hytte.json.PostModule;


public class RestApplicationControllerTest {
    
    private RestAppController restController;
    private Post post;
    private PostList postList;
    private PostList prevPostList;
    private HytteSave hytteSave;
    private HytteRead hytteRead;
    private ObjectMapper om = new ObjectMapper();

    @BeforeEach
    public void setUp() {
        om.registerModule(new PostModule());
        hytteSave = new HytteSave();
        hytteRead = new HytteRead();
        restController = new RestAppController();
        post = new Post("Ola Nordmann", "Hadde det gøy!", LocalDate.now());
        post.setDateRead("11. okt. 2022");;
        postList = new PostList();
        postList.addPost(post);

        //Save original data so you hyttebok keeps original data after testing
        prevPostList = hytteRead.read("hyttebok.json");
    }

    @Test
    public void testPostData() throws JsonProcessingException, Exception {
        assertTrue(restController.postData(om.writeValueAsString(postList)));
    }
    @Test
    public void testGetData() throws Exception {
        restController.postData(om.writeValueAsString(postList));
        assertEquals(restController.getPostList(), "{\"posts\":[{\"date\":\"11. okt. 2022\",\"name\":\"Ola Nordmann\",\"postText\":\"Hadde det gøy!\"}]}");
    }

    @AfterEach
    public void recreateFile() throws IOException {
        //Write to file again
        hytteSave.commitSave(prevPostList, "hyttebok.json");
    }

}
