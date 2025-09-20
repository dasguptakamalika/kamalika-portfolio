package com.kams.portfolio.post;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@Controller
public class PostController {

    private final PostRepository postRepository;

    public PostController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @GetMapping("/posts")
    public String showPosts(
            @RequestParam(required = false) String type,
            Model model) {

        List<Post> posts;

        if (type != null) {
            posts = postRepository.findByType(type);  // blog / photo
        } else {
            posts = postRepository.findAll();  // fallback: all posts
        }

        model.addAttribute("posts", posts);
        return "posts"; // loads posts.html
    }
}
