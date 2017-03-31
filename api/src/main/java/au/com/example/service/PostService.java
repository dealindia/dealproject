package au.com.example.service;

import java.util.List;

import au.com.example.api.model.post.Post;

public interface PostService {
	List<Post> getPosts();

    boolean deletePost(Long id);

    boolean savePost(Post post);
}
