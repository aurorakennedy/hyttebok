package hytte.core;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Post {
    
    private String name;
    private String content;
    private String date;

    public Post(String name, String content, LocalDate date){
        setName(name);
        setContent(content);
        setDate(date);
    }

    public String getName(){
        return this.name;
    }

    public String getContent(){
        return this.content;
    }

    public String getDate(){
        return this.date;
    }

    public void setName(String name){
        if (validName(name)){
            this.name = name;
        }
        else{
            throw new IllegalArgumentException("Name can only contain letters and spaces");
        }
    }

    public void setContent(String s){
        this.content = s;
    }

    public void setDate(LocalDate date){
        String formattedDate = date.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM));
        this.date = formattedDate;
    }

    public void setDateRead (String d) {
        this.date = d;
    }

    private Boolean validName(String s){
        if (s == null || s == ""){
            return false;
        }

        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (!Character.isLetter(c) && !Character.isWhitespace(c)){
                return false;
            }
        }
        return true;
    }

}
