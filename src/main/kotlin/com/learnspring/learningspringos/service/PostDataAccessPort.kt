package com.learnspring.learningspringos.service

import com.learnspring.learningspringos.model.Post
import java.util.UUID

interface PostDataAccessPort {
    fun save(post:Post) : Post
    fun findById(id: UUID) : Post?
    fun findAll() : List<Post>
}