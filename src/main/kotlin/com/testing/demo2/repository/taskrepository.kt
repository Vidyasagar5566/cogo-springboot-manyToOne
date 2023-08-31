package com.testing.demo2.repository

import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import com.testing.demo2.entity.Task

@Repository
interface TaskRepository : CrudRepository<Task, Int> {

    @Query("SELECT a from Task as a")
    fun getAllTasks(): List<Task>
}