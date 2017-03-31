package au.com.example.api.controller.post;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import au.com.example.api.model.post.Post;
import au.com.example.service.PostService;

@RestController
@RequestMapping(value = "/post")
public class PostController {
	@Autowired
	private PostService postService;

	@PreAuthorize("isAuthenticated()")
	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public List<Post> getCustomers() {
		return postService.getPosts();
	}

	@PreAuthorize("isAuthenticated()")
	@RequestMapping(method = RequestMethod.POST, produces = "application/json")
	public boolean savePost(@RequestBody Post post) {
		return postService.savePost(post);
	}

	@PreAuthorize("isAuthenticated()")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public boolean deletePost(@PathVariable Long id) {
		return postService.deletePost(id);
	}
}
