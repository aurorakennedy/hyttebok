package hytte.ui;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.ObjectMapper;

import hytte.core.Post;
import hytte.core.PostList;
import hytte.json.PostModule;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class HytteSave {

    private PostList list;

    public HytteSave (PostList list) {
        this.list = list;
    }

    public void commitSave () throws IOException {

        /*Release 2 forsøk på fillagring*/
        
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new PostModule());
        mapper.writeValue(new File("hyttebok.json"), list);

    }

}
