package com.learnspring.learningspringos.controller

import com.learnspring.learningspringos.service.CodeBlogServiceInterface
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.servlet.ModelAndView
import org.springframework.web.servlet.function.ServerResponse.notFound
import java.util.UUID


@Controller
@RequestMapping("posts")
class CodeBlogController(
    private val codeBlogService: CodeBlogServiceInterface
) {
    @GetMapping
    fun getPosts() : ModelAndView {
        val mv = ModelAndView("posts")

        val posts = codeBlogService.findAll()

        mv.addObject("posts",posts)
        return mv
    }

    @GetMapping("/{id}")
    fun getPostDetails(
        @PathVariable(value = "id") id : UUID
    ) : ModelAndView {
        val mv = ModelAndView("postDetails")

        codeBlogService.findById(id)?.let {
            mv.addObject("post",it)
        } ?: run {
            mv.addObject("post","notFound().build()")
        }
        return mv
    }
}