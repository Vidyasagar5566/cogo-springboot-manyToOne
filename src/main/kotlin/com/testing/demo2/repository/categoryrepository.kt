package com.testing.demo2.repository

import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import com.testing.demo2.entity.Category

@Repository
interface CategoryRepository : CrudRepository<Category, Int> {

    @Query("SELECT a from Category as a")
    fun getAllCategory(): List<Category>
}