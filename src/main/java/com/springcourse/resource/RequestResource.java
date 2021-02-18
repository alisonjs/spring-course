package com.springcourse.resource;

import com.springcourse.domain.Request;
import com.springcourse.domain.RequestStage;
import com.springcourse.service.RequestService;
import com.springcourse.service.RequestStageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="requests")
public class RequestResource {

    private final RequestService requestService;
    private final RequestStageService requestStageService;

    public RequestResource(RequestService requestService, RequestStageService requestStageService) {
        this.requestService = requestService;
        this.requestStageService = requestStageService;
    }

    @PostMapping
    public ResponseEntity<Request> save(@RequestBody Request request){
        Request createdRequest = requestService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRequest);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Request> update(@PathVariable(name="id") Long id, @RequestBody  Request request){
        request.setId(id);
        Request updatedRequest = requestService.save(request);
        return ResponseEntity.ok(updatedRequest);
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

    @GetMapping("/{id}/request-stages")
    public ResponseEntity<List<RequestStage>> listAllStagesById(@PathVariable(name="id")Long id){
        List<RequestStage> stages = requestStageService.listAllByRequestId(id);
        return ResponseEntity.ok(stages);
    }
}
