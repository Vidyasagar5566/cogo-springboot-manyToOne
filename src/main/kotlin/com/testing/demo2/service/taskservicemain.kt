package com.testing.demo2.service

import org.springframework.stereotype.Service
import com.testing.demo2.dto.TaskDto
import com.testing.demo2.repository.TaskRepository
import com.testing.demo2.repository.CategoryRepository
import com.testing.demo2.mapper.TaskMapper
import com.testing.demo2.exceptions.TaskException
import com.testing.demo2.mapper.CategoryMapper


@Service
class TaskServiceimain(
    private val TaskRepository: TaskRepository,
    private val TaskMapper: TaskMapper,
    private val CategoryRepository: CategoryRepository,
    private val CategoryMapper: CategoryMapper
) : TaskService {
    override fun createTask(TaskDto: TaskDto): TaskDto {
        if (TaskDto.id != null) {
            throw TaskException("Id should be null")
        }
        var id = TaskDto.category?.id!!
        var category = CategoryRepository.findById(id).orElseThrow {
            TaskException("Movie with $id doesn't exist")
        }
        TaskDto.category = CategoryMapper.toDto(category)
        val task = TaskMapper.toEntity(TaskDto)
        TaskRepository.save(task)
        return TaskMapper.toDto(task);
    }

    override fun getTask(id: Int): TaskDto {
        var task = TaskRepository.findById(id).orElseThrow {
            TaskException("Movie with $id doesn't exist")
        }
        return TaskMapper.toDto(task)
    }

    override fun getTask(): List<TaskDto> {
        var tasks = TaskRepository.getAllTasks()
        if (tasks.isEmpty()) {
            throw TaskException("Movie list is empty")
        }
        return tasks.map {
            TaskMapper.toDto(it)
        }
    }

    override fun updateTask(TaskDto: TaskDto): TaskDto {
        getTask(TaskDto.id!!)
        TaskRepository.save(TaskMapper.toEntity(TaskDto))
        return TaskDto
    }

    override fun deleteTask(id: Int) {
        val exists = TaskRepository.existsById(id);
        if (!exists)
            throw TaskException("Movie with $id doesn't exist")
        TaskRepository.deleteById(id)
    }
}