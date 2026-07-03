package com.syahir.todoapp.mapper;

public interface Mapper <A,B>{
    B mapTo(A a);

    A mapFrom(B b);
}
