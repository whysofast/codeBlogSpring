package com.learnspring.learningspringos.controller

import com.learnspring.learningspringos.model.Post
import com.learnspring.learningspringos.service.CodeBlogServiceInterface
import org.springframework.stereotype.Controller
import org.springframework.validation.BindingResult
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.ModelAndView
import org.springframework.web.servlet.mvc.support.RedirectAttributes
import java.time.LocalDate
import java.util.UUID


@Controller
@RequestMapping("posts")
class CodeBlogController(
    private val codeBlogService: CodeBlogServiceInterface
) {
    @GetMapping
    fun getPosts() : ModelAndView {
        val mv = ModelAndView("posts")

        val posts = codeBlogService.encontrarTodos()

        mv.addObject("posts",posts)
        return mv
    }

    @GetMapping("/{id}")
    fun getPostDetails(
        @PathVariable(value = "id") id : UUID
    ) : ModelAndView {
        val mv = ModelAndView("postDetails")

        codeBlogService.encontrarPorId(id)?.let {
            mv.addObject("post",it)
        } ?: run {
            mv.addObject("post","notFound().build()")
        }
        return mv
    }

    @GetMapping("/newpost")
    fun getPostForm() : String {
        return "postForm"
    }

    @PostMapping("/newpost")
    fun createPost(
        @Validated post: Post, result: BindingResult, attributes: RedirectAttributes
    ) : String {
        if (result.hasErrors())  return "redirect:/newpost"

        post.data = LocalDate.now()
        codeBlogService.salvar(post)
        println(post)
        return "redirect:/posts"
    }
}