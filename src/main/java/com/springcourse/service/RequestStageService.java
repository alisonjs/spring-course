package com.springcourse.service;

import com.springcourse.domain.RequestStage;
import com.springcourse.domain.enums.RequestState;
import com.springcourse.repository.RequestRepository;
import com.springcourse.repository.RequestStageRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class RequestStageService {

    private final RequestStageRepository requestStageRepository;

    private final RequestRepository requestRepository;

    public RequestStageService(RequestStageRepository requestStageRepository, RequestRepository requestRepository) {
        this.requestStageRepository = requestStageRepository;
        this.requestRepository = requestRepository;
    }

    public RequestStage save(RequestStage stage){
        stage.setRealizationDate(new Date());
        RequestStage createdStage = requestStageRepository.save(stage);

        Long requestId = stage.getRequest().getId();
        RequestState state = stage.getState();

        requestRepository.updateStatus(requestId, state);

        return createdStage;
    }

    public RequestStage getById(Long id){
        Optional<RequestStage> result =  requestStageRepository.findById(id);
        return result.orElse(null);
    }

    public List<RequestStage> listAllByRequestId(Long requestId){
        return requestStageRepository.findAllByRequestId(requestId);
    }
}
