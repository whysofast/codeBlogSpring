package com.learnspring.learningspringos.utils

import com.learnspring.learningspringos.model.Post
import com.learnspring.learningspringos.repository.CodeBlogRepository
import org.springframework.stereotype.Component
import java.time.LocalDate
import javax.annotation.PostConstruct

@Component
class DummyData(
    private val postRepository: CodeBlogRepository
) {

//    @PostConstruct
    fun savePosts(){

        val post = Post(
            id = "f3b072ec-018c-4bb3-9210-b47ded53cc3d",
            author = "Autor",
            data = LocalDate.now(),
            title = "Titulo",
            text = "Lorem lorem ipsum"
        )

        val post1 = Post(
            id = "f3b072ec-018c-4bb3-9210-b47ded53cc3d",
            author = "Autor1",
            data = LocalDate.now(),
            title = "Titulo1",
            text = "Lorem lorem ipsum1"
        )

        val post2 = Post(
            id = "f3b072ec-018c-4bb3-9210-b47ded53cc3d",
            author = "Autor2",
            data = LocalDate.now(),
            title = "Titulo2",
            text = "Lorem lorem ipsum2"
        )

        postRepository.save(post)
        postRepository.save(post1)
        postRepository.save(post2)
    }

}