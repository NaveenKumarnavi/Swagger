package com.extendo.LOB.controller;

//import com.extendo.LOB.ErrorResponse.CustomExceptionHandler;
import com.extendo.LOB.ErrorResponse.ErrorHandler;
//import com.extendo.LOB.ErrorResponse.ErrorResponse;
import com.extendo.LOB.ErrorResponse.RecordNotFoundException;
import com.extendo.LOB.entity.Lob;
import com.extendo.LOB.repository.LobRepository;
import com.extendo.LOB.response.ResponseHandler;
import com.extendo.LOB.service.LobService;
//import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LobController {
    @Autowired
    private LobService service;

    public LobController(LobService service, LobRepository lobRepository){

        this.service = service;
    }
    @PostMapping("/addLob")
    public ResponseEntity<Object> Post(@RequestBody Lob lob){
        try{
           Lob result = service.saveLob(lob);
           return ResponseHandler.generateResponse("Successfully added data!",HttpStatus.OK,result);
        }catch (Exception e){

            return ResponseHandler.generateResponse(e.getMessage(),HttpStatus.MULTI_STATUS,null);
        }
    }
    @GetMapping("/Lobs")
    public ResponseEntity<Object> Get(){
        try {
            List<Lob> result = (List<Lob>) service.getLobs();
            if(result==null){
                throw new RecordNotFoundException("Record_Not_Found");
            }
            return  ResponseHandler.generateResponse("Successfully retrieved Data!",HttpStatus.OK,result);
        }catch(Exception e){

            return  ResponseHandler.generateResponse(e.getMessage(),HttpStatus.MULTI_STATUS,null);
        }
     
    }
     @GetMapping("/Lobs/{lobCode}")
    public ResponseEntity<Object> Get(@PathVariable String lobCode) {
try{
    Lob result =  this.service.getLobByLOBCode(lobCode);
    if(result==null){
        throw new RecordNotFoundException("Record_Not_Found");
    }
    return ResponseHandler.generateResponse("Successfully retrieved data!",HttpStatus.OK,result);
}catch(RecordNotFoundException e){
    return ErrorHandler.ErrorResponse(e.getMessage(),HttpStatus.BAD_REQUEST);
}
     }
            





    
    @PutMapping("/update")
    public ResponseEntity<Object> Update(@RequestBody Lob lob){
        try{
            Lob result = service.saveLob(lob);
            if(result==null){
                throw new RecordNotFoundException("Record_Not_Found");
            }
            return ResponseHandler.generateResponse("updated",HttpStatus.OK,result);
        }catch (Exception e){
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS,null);
        }
    }
   

    @DeleteMapping("/delete/{lobCode}")
    public ResponseEntity<Object> Delete(@PathVariable String lobCode){
        try{
            String result = service.deleteLob(lobCode);
            if(result==null){
                throw new RecordNotFoundException("Record_Not_Found");
            }
            return ResponseHandler.generateResponse("Deleted!", HttpStatus.OK, result);
        }catch (Exception e){
            return  ResponseHandler.generateResponse(e.getMessage(),HttpStatus.MULTI_STATUS,null);
        
        }
    }
   

}
