package com.extendo.LOB.response;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

//import java.util.Date;
import java.util.HashMap;
//import java.util.List;
import java.util.Map;

//import static com.sun.org.apache.xalan.internal.xsltc.compiler.sym.error;

public class ResponseHandler {
    public static ResponseEntity<Object> handleUserNotFoundException;

    public static ResponseEntity<Object> generateResponse(String message, HttpStatus status, Object responseObj) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("message", message);
        map.put("status", status.value());
       map.put("data", responseObj);
       // map.put("timestamp", status.value());

        return new ResponseEntity<Object>(map,status);
    }
/*
    public static ResponseEntity<Object> ErrorResponse(String message, HttpStatus status, Object responseObj) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("message", message);
        map.put("status", status.value());
        map.put("data", responseObj);
        return new ResponseEntity<Object>(map,status);

    }
 */

    // public static ResponseEntity<Object> handleUserNotFoundException() {
     //   return new ResponseEntity(error, HttpStatus.NOT_FOUND);
    //}
}