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
    override fun salvar(post: Post): Post {
        return postRepository.save(post)
    }

    override fun encontrarPorId(id: UUID): Post {
        return postRepository.findById(id.toString()).get()
    }

    override fun encontrarTodos(): List<Post> {
        return postRepository.findAll()
    }
}