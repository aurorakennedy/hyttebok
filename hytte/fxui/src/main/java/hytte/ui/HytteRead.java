package hytte.ui;

import java.io.IOException;
import java.nio.file.Paths;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.ObjectMapper;

import hytte.core.PostList;
import hytte.json.PostModule;

public class HytteRead {
    

    public HytteRead () {}

    public PostList read () {
        
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new PostModule());

        try {
            return mapper.readValue(Paths.get("hyttebok.json").toFile(), PostList.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
