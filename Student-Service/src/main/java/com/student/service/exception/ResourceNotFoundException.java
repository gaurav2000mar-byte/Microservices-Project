package com.student.service.exception;

public class ResourceNotFoundException extends RuntimeException {

        public ResourceNotFoundException(String msg)
        {
             super(msg);
        }
}
