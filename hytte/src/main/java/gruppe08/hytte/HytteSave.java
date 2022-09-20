package gruppe08.hytte;
import java.time.LocalDate;
import org.json.JSONObject;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class HytteSave {

    private String visitors;
    private String experience;
    private LocalDate datePicker;

    public HytteSave (String visitors, String experience, LocalDate datePicker) {
        this.visitors = visitors;
        this.experience = experience;
        this.datePicker = datePicker;
    }

    public void commitSave () throws IOException {
        
        //Save info in JSON file
        JSONObject obj = new JSONObject();
        obj.put("name", visitors);
        obj.put("experience", experience);
        obj.put("date", datePicker);

        String filePath = ("hyttebok.json");

        try (FileWriter writer = new FileWriter(filePath, true)) {
            BufferedWriter buffed = new BufferedWriter(writer);

            buffed.newLine();
            buffed.write(obj.toString());
            buffed.close();
        }

    }

}
