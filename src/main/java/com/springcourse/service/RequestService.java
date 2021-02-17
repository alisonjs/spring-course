package com.springcourse.service;

import com.springcourse.domain.Request;
import com.springcourse.domain.enums.RequestState;
import com.springcourse.repository.RequestRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class RequestService {

    private final RequestRepository requestRepository;

    public RequestService(RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

    public Request save(Request request){

        request.setState(RequestState.OPEN);
        request.setCreationDate(new Date());

        return requestRepository.save(request);
    }

    public Request update(Request request){
        return requestRepository.save(request);
    }

    public Request getById(Long id){
        Optional<Request> result =  requestRepository.findById(id);
        return result.orElse(null);
    }

    public List<Request> listAll(){
        return requestRepository.findAll();
    }

    public List<Request> listAllByOwnerId(Long ownerId){
        return requestRepository.findAllByOwnerId(ownerId);
    }

}
