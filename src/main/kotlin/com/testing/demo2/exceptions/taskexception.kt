package com.testing.demo2.exceptions

import java.lang.Exception

internal class TaskException(override val message: String?) : Exception(message) {
}