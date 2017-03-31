package au.com.example.persistence.dao.post;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import au.com.example.api.model.post.Post;
import au.com.example.exception.UpdateDeleteException;
import au.com.example.persistence.dao.base.BaseDao;
import au.com.example.persistence.dao.post.entity.PostEntity;
import au.com.example.persistence.dao.post.query.SelectPost;

@Repository
public class PostDaoImpl extends BaseDao implements PostDao {

    private static Logger log = LoggerFactory.getLogger(PostDaoImpl.class);

    @Transactional(readOnly = true)
    @Override
    public List<Post> getPosts() {
        List<Post> posts = new ArrayList<Post>();

        Collection<PostEntity> postEntitys = loadData(PostEntity.class, new SelectPost());

        if (postEntitys == null || postEntitys.isEmpty()) {
            log.info("No Post found");
        }
        else
        {
            for(PostEntity postEntity : postEntitys) {
            	posts.add(toPost(postEntity));
            }
        }

        return posts;
    }

    @Transactional
    @Override
    public boolean deletePost(Long id) {
        boolean success = false;

        try {
            success = deleteSingleData(PostEntity.class, id);
        }
        catch(UpdateDeleteException e) {
            log.error("Error deleting Post with id: " + id);
        }

        return success;
    }

    @Transactional
    @Override
    public boolean savePost(Post post) {
        boolean success = false;

        try {
            success = updateSingleData(toPostEntity(post));
        }
        catch(UpdateDeleteException e) {
            log.error("Error saving Post with id: " + post.getId());
        }

        return success;
    }

    // ======== Helpers =========

    private Post toPost(PostEntity postEntity) {
        Post post = null;

        if(postEntity != null) {
        	post = new Post(postEntity.getId(), postEntity.getFirstName(), postEntity.getLastName());
        }

        return post;
    }

    private PostEntity toPostEntity(Post post) {
    	PostEntity entity = null;

        if(post != null) {
            entity = new PostEntity(post.getId(), post.getFirstName(), post.getLastName());
        }

        return entity;
    }
}
