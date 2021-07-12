package com.learnspring.learningspringos.repository

import com.learnspring.learningspringos.model.Post
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CodeBlogRepository : JpaRepository<Post,String>