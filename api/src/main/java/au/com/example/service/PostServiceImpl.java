package au.com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import au.com.example.api.model.post.Post;
import au.com.example.persistence.dao.post.PostDao;

@Service(value = "PostService")
public class PostServiceImpl implements PostService {

    @Autowired
    private PostDao postDao;

	@Override
	public List<Post> getPosts() {
		return postDao.getPosts();
	}

    @Override
    public boolean deletePost(Long id) {
        return postDao.deletePost(id);
    }

    @Override
    public boolean savePost(Post post) { return postDao.savePost(post); }
}
