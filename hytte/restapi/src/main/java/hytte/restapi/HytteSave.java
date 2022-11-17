package hytte.restapi;

import com.fasterxml.jackson.databind.ObjectMapper;
import hytte.core.PostList;
import hytte.json.PostModule;
import java.io.File;
import java.io.IOException;

public class HytteSave {

    public HytteSave() { }

    /**
     * @param list The PostList you want to write to file.
     * @param fileName Name of the file you want to write to.
     * @throws IOException If unable to write to given file.
     */
    public void commitSave(PostList list, String fileName) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new PostModule());
        String path = System.getProperty("user.dir") + "//savestate//";
        mapper.writeValue(new File(path, fileName), list);
    }
}
