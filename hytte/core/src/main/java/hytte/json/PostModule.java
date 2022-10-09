package hytte.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.util.VersionUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

import hytte.core.Post;



public class PostModule extends SimpleModule{
    
    private static final String NAME = "PostModule";
    private static final VersionUtil VERSION_UTIL = new VersionUtil(){};

    public PostModule () {
        super(NAME, VERSION_UTIL.version());
        addSerializer(Post.class, new PostSerializer());
    }

    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new PostModule());

        Post post = new Post("Aksel", "Heisann", null);
        System.out.println(mapper.writeValueAsString(post));

    }

}
