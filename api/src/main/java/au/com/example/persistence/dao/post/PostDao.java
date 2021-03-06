package au.com.example.persistence.dao.post;

import java.util.List;

import au.com.example.api.model.post.Post;

public interface PostDao {

	List<Post> getPosts();

	boolean deletePost(Long id);

	boolean savePost(Post post);
}
