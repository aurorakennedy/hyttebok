package gruppe08.hytte;

import java.util.ArrayList;
import java.util.List;

public class PostList {
    
    private List<Post> postList = new ArrayList<Post>();

    public void addPost(Post post){
        if (!postList.contains(post)){
            this.postList.add(post);
        }
        else{
            throw new IllegalArgumentException("PostList already contains the post");
        }
    }

    public void removePost(Post post){
        if (postList.contains(post)){
            postList.remove(post);
        }
    }

    public List<Post> getPostList(){
        List<Post> copiedList = new ArrayList<Post>();
        for (Post post : postList) {
            copiedList.add(post);
        }
        return copiedList;
    }

    /**
     * @param name 
     * The string you want to get posts by
     * @return
     * List of posts authored by name
     */
    public List<Post> getPostsByName(String name){
        List<Post> postsByName = new ArrayList<Post>();
        for (Post post : postList) {
            if (post.getName() == name){
                postsByName.add(post);
            }
        }
        return postsByName;
    }


}
