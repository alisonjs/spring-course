package com.springcourse.resource;

import com.springcourse.domain.RequestStage;
import com.springcourse.service.RequestStageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="request-stages")
public class RequestStageResource {


    private final RequestStageService requestStageService;

    public RequestStageResource(RequestStageService requestStageService) {
        this.requestStageService = requestStageService;
    }

    @PostMapping
    public ResponseEntity<RequestStage> save(@RequestBody RequestStage stage){
        RequestStage createdRequestStage = requestStageService.save(stage);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRequestStage);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RequestStage> getById(@PathVariable(name="id") Long id){
        RequestStage stage = requestStageService.getById(id);
        return ResponseEntity.ok(stage);
    }
}
