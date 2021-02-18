package com.springcourse.resource;

import com.springcourse.domain.Request;
import com.springcourse.service.RequestService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="requests")
public class RequestResource {

    private final RequestService requestService;

    public RequestResource(RequestService requestService) {
        this.requestService = requestService;
    }

    @PostMapping
    public ResponseEntity<Request> save(@RequestBody Request request){
        Request createdRequest = requestService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(request);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Request> update(@PathVariable(name="id") Long id, @RequestBody  Request request){
        request.setId(id);
        Request updatedRequest = requestService.save(request);
        return ResponseEntity.ok(request);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Request> getById(@PathVariable(name="id") Long id){
        Request request = requestService.getById(id);
        return ResponseEntity.ok(request);
    }

    @GetMapping
    public ResponseEntity<List<Request>> listAll(){
        List<Request> requests = requestService.listAll();
        return ResponseEntity.ok(requests);
    }
}
