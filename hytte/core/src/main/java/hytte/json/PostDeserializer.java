package hytte.json;

import java.io.IOException;


import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;

import hytte.core.Post;

public class PostDeserializer extends JsonDeserializer<Post> {

    @Override
    public Post deserialize(JsonParser parser, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        
        TreeNode treeNode = parser.getCodec().readTree(parser);
        return deserialize((JsonNode) treeNode);
    }

    public Post deserialize(JsonNode jsonNode) {
        
        if (jsonNode instanceof ObjectNode) {
            ObjectNode objectNode = (ObjectNode) jsonNode;

            Post post = new Post(null, null, null);

            /*JsonNode dateNode = objectNode.get("date");
            if (dateNode instanceof TextNode) {
                Date date = new SimpleDateFormat("dd/MM/yyy").parse(dateNode.asText());
                post.setDate((null));
            }*/
            JsonNode nameNode = objectNode.get("name");
            if (nameNode instanceof TextNode) {
                post.setName(((TextNode) nameNode).asText());
            }
            JsonNode contentNode = objectNode.get("postText");
            if (contentNode instanceof TextNode) {
                post.setContent(((TextNode) contentNode).asText());
            }
            return post;
        }
        return null;
    }
    
    
}
