package com.testing.demo2.service


import org.springframework.stereotype.Service
import com.testing.demo2.dto.CategoryDto
import com.testing.demo2.repository.CategoryRepository
import com.testing.demo2.mapper.CategoryMapper
import com.testing.demo2.exceptions.TaskException

@Service
class CategoryServiceimain(
    private val CategoryRepository: CategoryRepository,
    private val CategoryMapper: CategoryMapper
) : CategoryService {
    override fun createCategory(categoryDto: CategoryDto): CategoryDto {
        if (categoryDto.id != null) {
            throw TaskException("Id should be null")
        }
        val category = CategoryMapper.toEntity(categoryDto)
        CategoryRepository.save(category)
        return CategoryMapper.toDto(category);
    }

    override fun getCategory(id: Int): CategoryDto {
        var category = CategoryRepository.findById(id).orElseThrow {
            TaskException("Movie with $id doesn't exist")
        }
        return CategoryMapper.toDto(category)
    }

    override fun getCategory(): List<CategoryDto> {
        var categories = CategoryRepository.getAllCategory()
        if (categories.isEmpty()) {
            throw TaskException("Movie list is empty")
        }
        return categories.map {
            CategoryMapper.toDto(it)
        }
    }

    override fun updateCategory(TaskDto: CategoryDto): CategoryDto {
        getCategory(TaskDto.id!!)
        CategoryRepository.save(CategoryMapper.toEntity(TaskDto))
        return TaskDto
    }

    override fun deleteCategory(id: Int) {
        val exists = CategoryRepository.existsById(id);
        if (!exists)
            throw TaskException("Movie with $id doesn't exist")
        CategoryRepository.deleteById(id)
    }
}