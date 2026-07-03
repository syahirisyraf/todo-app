package com.syahir.todoapp.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public enum TaskStatus {
    TODO,
    IN_PROGRESS,
    DONE
}
