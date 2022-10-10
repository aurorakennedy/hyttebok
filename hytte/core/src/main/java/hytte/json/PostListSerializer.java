package hytte.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import hytte.core.Post;
import hytte.core.PostList;

public class PostListSerializer extends JsonSerializer<PostList>{

    /*
     format:
     {
        "posts" : [
            {Post},
            {Post},
            ...
        ]
     }
     */

    @Override
    public void serialize(PostList list, JsonGenerator jGen, SerializerProvider serializerProvider) throws IOException {
        jGen.writeStartObject();
        jGen.writeArrayFieldStart("posts");
        for (Post post : list.getPostList()) {
            jGen.writeObject(post);
        }
        jGen.writeEndArray();
        jGen.writeEndObject();
        
    }
    
}
