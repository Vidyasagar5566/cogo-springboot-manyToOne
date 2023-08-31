package com.testing.demo2.dto


data class TaskDto(var id: Int?, var title: String, var description: String,
                   var duedate:String,var completed: Boolean,var category: CategoryDto?)