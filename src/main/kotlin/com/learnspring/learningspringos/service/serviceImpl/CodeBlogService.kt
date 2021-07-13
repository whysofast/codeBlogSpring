package com.learnspring.learningspringos.service.serviceImpl

import com.learnspring.learningspringos.model.Post
import com.learnspring.learningspringos.repository.CodeBlogRepository
import com.learnspring.learningspringos.service.CodeBlogServiceInterface
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class CodeBlogService(
    private val postRepository: CodeBlogRepository
) : CodeBlogServiceInterface {
    override fun save(post: Post): Post {
        return postRepository.save(post)
    }

    override fun findById(id: UUID): Post {
        return postRepository.findById(id.toString()).get()
    }

    override fun findAll(): List<Post> {
        return postRepository.findAll()
    }
}