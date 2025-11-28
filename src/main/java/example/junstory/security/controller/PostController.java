package example.junstory.security.controller;

import example.junstory.security.entity.Post;
import example.junstory.security.service.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
@CrossOrigin(origins = "http://localhost:3000")
public class PostController {
    private final PostService service;

    public PostController(PostService service) {
        this.service = service;
    }

    @GetMapping
    public List<Post> list() {
        return service.listAll();
    }

    @GetMapping("/{id}")
    public Post detail(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public Post create(@RequestBody Post post) {
        return service.save(post);
    }

    @PutMapping("/{id}")
    public Post update(@PathVariable Long id, @RequestBody Post post) {
        post.setId(id);
        return service.save(post);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
