package com.learnspring.learningspringos.service

import com.learnspring.learningspringos.model.Post
import java.util.UUID

interface CodeBlogServiceInterface {
    fun salvar(post:Post) : Post
    fun encontrarPorId(id: UUID) : Post?
    fun encontrarTodos() : List<Post>
}