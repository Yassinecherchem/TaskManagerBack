package com.example.taskmanager.mappers;

public interface IMapper<T, REQUEST, RESPONSE> {

    T requestToObject(REQUEST request);
    RESPONSE objectToResponse(T object);
    
}
