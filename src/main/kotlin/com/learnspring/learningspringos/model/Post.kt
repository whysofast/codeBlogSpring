package com.learnspring.learningspringos.model

import org.hibernate.annotations.GenericGenerator
import java.time.LocalDate
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Lob

@Entity(name = "post")
data class Post (
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    var id: String?,

    var title: String,

    var author: String,

    @Lob
    var text: String,

    var data: LocalDate?


    )
{

}