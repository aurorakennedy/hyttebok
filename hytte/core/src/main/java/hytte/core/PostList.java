package hytte.core;

import java.util.ArrayList;
import java.util.List;

public class PostList {

    private List<Post> postList = new ArrayList<Post>();

    public void addPost(Post post) {
        if (!postList.contains(post)) {
            this.postList.add(post);
        } else {
            throw new IllegalArgumentException("PostList already contains the post");
        }
    }

    public void removePost(Post post) {
        if (postList.contains(post)) {
            postList.remove(post);
        }
    }

    public List<Post> getPostList() {
        List<Post> copiedList = new ArrayList<Post>();
        for (Post post : postList) {
            copiedList.add(post);
        }
        return copiedList;
    }
}
