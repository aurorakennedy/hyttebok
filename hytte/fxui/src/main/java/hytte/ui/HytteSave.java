package hytte.ui;

import com.fasterxml.jackson.databind.ObjectMapper;
import hytte.core.PostList;
import hytte.json.PostModule;
import java.io.File;
import java.io.IOException;

public class HytteSave {

    public HytteSave() { }

    public void commitSave(PostList list, String fileName) throws IOException {

        /*Release 2 forsøk på fillagring*/
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new PostModule());
        mapper.writeValue(new File("savestate", fileName), list);

    }

}
