package hytte.restapi;

import com.fasterxml.jackson.databind.ObjectMapper;
import hytte.core.PostList;
import hytte.json.PostModule;
import java.io.File;
import java.io.IOException;

public class HytteSave {

    public HytteSave() { }

    public void commitSave(PostList list, String fileName) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new PostModule());
        String path = "//savestate//";
        mapper.writeValue(new File(path, fileName), list);
    }

}