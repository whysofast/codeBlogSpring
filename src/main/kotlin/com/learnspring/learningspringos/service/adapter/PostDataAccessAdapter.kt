package com.learnspring.learningspringos.service.adapter

import com.learnspring.learningspringos.model.Post
import com.learnspring.learningspringos.repository.CodeBlogRepository
import com.learnspring.learningspringos.service.PostDataAccessPort
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class PostDataAccessAdapter(
    @Autowired
    private val postRepository: CodeBlogRepository
) : PostDataAccessPort {
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