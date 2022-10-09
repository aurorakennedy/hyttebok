package hytte.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.util.VersionUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

import hytte.core.Post;
import hytte.core.PostList;



public class PostModule extends SimpleModule{
    
    private static final String NAME = "PostModule";
    private static final VersionUtil VERSION_UTIL = new VersionUtil(){};
    private final static String postList = "{\"posts\":[{\"name\":\"aksel\",\"postText\":\"hei\"}]}";

    public PostModule () {
        super(NAME, VERSION_UTIL.version());
        addSerializer(Post.class, new PostSerializer());
        addSerializer(PostList.class, new PostListSerializer());
        addDeserializer(Post.class, new PostDeserializer());
        addDeserializer(PostList.class, new PostListDeserializer());
    }

    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new PostModule());

        try {
            PostList list = mapper.readValue(postList, PostList.class);
            System.out.println(postList);
            System.out.println(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
