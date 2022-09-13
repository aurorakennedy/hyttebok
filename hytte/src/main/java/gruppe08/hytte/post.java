package gruppe08.hytte;

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
        if (s == null){
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

    
    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        Post post1 = new Post("aaHH JJl DdFIEFØ", "Her er innmaten", date);
        //Post post2 = new Post("asdf1132", "Her er innmaten igjen 123", date);
        System.out.println(post1.getDate());
    }
}
