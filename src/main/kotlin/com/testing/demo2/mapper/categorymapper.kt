package com.testing.demo2.mapper

import com.testing.demo2.dto.CategoryDto
import com.testing.demo2.entity.Category
import org.springframework.stereotype.Service

@Service
class CategoryMapper : Mapper<CategoryDto, Category> {
    override fun toDto(entity: Category): CategoryDto {
        return CategoryDto(
            entity.id,
            entity.name,
        )
    }

    override fun toEntity(dto: CategoryDto): Category {
        return Category(
            dto.id,
            dto.name,
        )
    }
}