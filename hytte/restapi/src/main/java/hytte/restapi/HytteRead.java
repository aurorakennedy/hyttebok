package hytte.restapi;

import java.io.File;
import java.nio.file.Paths;
import com.fasterxml.jackson.databind.ObjectMapper;

import hytte.core.PostList;
import hytte.json.PostModule;

public class HytteRead {

    public HytteRead() { }

    /**
     * @param fileName Name of the file you want to read from.
     * @return The PostList object stored in fileName.
     */
    public PostList read(String fileName) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new PostModule());
        File file = Paths.get(System.getProperty("user.dir"), "//savestate//", fileName).toFile();
        try {
            return mapper.readValue(file, PostList.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
