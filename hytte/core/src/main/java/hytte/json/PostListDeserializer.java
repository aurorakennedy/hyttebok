package hytte.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import hytte.core.PostList;
import hytte.core.Post;

public class PostListDeserializer extends JsonDeserializer<PostList>{

    private PostDeserializer postDeserializer = new PostDeserializer();

    @Override
    public PostList deserialize(JsonParser parser, DeserializationContext ctxt) throws IOException, JsonProcessingException {
       
        TreeNode treeNode = parser.getCodec().readTree(parser);
        if (treeNode instanceof ObjectNode) {
            ObjectNode objectNode = (ObjectNode) treeNode;
            PostList list = new PostList();
            JsonNode postsNode = objectNode.get("posts");
            if (postsNode instanceof ArrayNode) {
                for (JsonNode elementNode :((ArrayNode) postsNode)) {
                    Post post = postDeserializer.deserialize(elementNode);
                    if (post != null) {
                        list.addPost(post);
                    }
                }
            }
            return list;
        }
        return null;
    }
    
}
