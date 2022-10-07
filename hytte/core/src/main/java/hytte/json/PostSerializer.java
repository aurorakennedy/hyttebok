package hytte.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import hytte.core.Post;

public class PostSerializer extends JsonSerializer<Post> {

    /*
     format:
     {
        "date": 00:00:0000,
        "name": "text",
        "postText": "text"
     }
     */
  
    @Override
    public void serialize(Post post, JsonGenerator jGen, SerializerProvider serializerProvider) throws IOException {
      jGen.writeStartObject();
      /*jGen.writeDateField("date", post.getDate());*/
      jGen.writeStringField("name", post.getName());
      jGen.writeStringField("postText", post.getContent());
      jGen.writeEndObject();
    }
  }