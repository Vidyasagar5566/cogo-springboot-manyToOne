package com.testing.demo2.exceptions

import java.lang.Exception

internal class CategoryException(override val message: String?) : Exception(message) {
}