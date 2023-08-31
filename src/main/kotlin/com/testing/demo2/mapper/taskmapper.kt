package com.testing.demo2.mapper

import org.springframework.stereotype.Service
import com.testing.demo2.dto.TaskDto
import com.testing.demo2.entity.Task


@Service
class TaskMapper (
    private val CategoryMapper : CategoryMapper
): Mapper<TaskDto, Task> {


    override fun toDto(entity: Task): TaskDto {
        return TaskDto(
            entity.id,
            entity.title,
            entity.description,
            entity.duedate,
            entity.completed,
            CategoryMapper.toDto(entity.category!!)
        )
    }

    override fun toEntity(dto: TaskDto): Task {
        return Task(
            dto.id,
            dto.title,
            dto.description,
            dto.duedate,
            dto.completed,
            CategoryMapper.toEntity(dto.category!!)
        )
    }
}
