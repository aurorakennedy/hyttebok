package hytte.json;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import hytte.core.Post;
import hytte.core.PostList;

public class PostModuleTest {

    private static ObjectMapper mapper;
    private PostList postList;
    private String postListString = "{\"posts\":[{\"date\":\"11. okt. 2022\",\"name\":\"Ola Nordmann\",\"postText\":\"Hadde det gøy!\"}]}";
    
    @BeforeAll
    public static void setUp() {
        mapper = new ObjectMapper();
        mapper.registerModule(new PostModule());
    }

    @Test
    public void testSerializers()  {
        Post post = new Post("Ola Nordmann", "Hadde det gøy!", LocalDate.now());
        post.setDateRead("11. okt. 2022");
        PostList postList = new PostList();
        postList.addPost(post);
        try {
            assertEquals(postListString, 
            mapper.writeValueAsString(postList));
        } catch(JsonProcessingException e) {
            fail();
        }
    }

    @Test
    public void testDeserializers() {
        try {
            mapper.writeValueAsString(postList);
            PostList readPostList = mapper.readValue(postListString, PostList.class);
            Post readPost = readPostList.getPostList().get(0);
            assertEquals(readPost.getName(), "Ola Nordmann");
            assertEquals(readPost.getDate(), "11. okt. 2022");
            assertEquals(readPost.getContent(), "Hadde det gøy!");
        } catch(JsonProcessingException e) {
            fail();
        }
    }



}
