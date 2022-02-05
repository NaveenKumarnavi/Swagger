package com.extendo.LOB.ErrorResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ErrorHandler {

//import static com.sun.org.apache.xalan.internal.xsltc.compiler.sym.error;


    public static ResponseEntity<Object> handleUserNotFoundException;

    public static ResponseEntity<Object> ErrorResponse(String message, HttpStatus status) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("message", message);
        map.put("status", status.value());

        // map.put("timestamp", status.value());

        return new ResponseEntity<Object>(map, status);
    }
}