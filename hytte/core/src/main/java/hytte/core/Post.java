package hytte.core;

import java.time.LocalDate;

public class Post {
    
    private String name;
    private String content;
    private LocalDate date;

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

    public LocalDate getDate(){
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
        this.date = date;
    }


    private Boolean validName(String s){
        System.out.println(s);
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
