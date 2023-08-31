package com.testing.demo2.service

import com.testing.demo2.dto.CategoryDto

interface CategoryService {
    fun createCategory(Task: CategoryDto): CategoryDto
    fun getCategory(): List<CategoryDto>
    fun getCategory(id: Int): CategoryDto
    fun updateCategory(Task: CategoryDto): CategoryDto
    fun deleteCategory(id: Int)
}

