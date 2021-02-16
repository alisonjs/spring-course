package com.springcourse.repository;

import com.springcourse.domain.Request;
import com.springcourse.domain.User;
import com.springcourse.domain.enums.RequestState;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.assertj.core.api.Assertions;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest
public class RequestRepositoryTest {

    @Autowired
    private RequestRepository requestRepository;

    @Test
    public void AsaveTest(){
        Request request = Request.builder()
                .id(null)
                .subject("New Laptop HP")
                .description("Getting a new laptop HP")
                .creationDate(new Date())
                .state(RequestState.OPEN)
                .owner(User.builder().id(1L).build())
                .stages(null)
                .build();

        Request createdRequest = requestRepository.save(request);

        Assertions.assertThat(createdRequest.getId()).isEqualTo(1L);
    }

    @Test
    public void updateTest(){
        Request request = Request.builder()
                .id(1L)
                .subject("New Laptop HP")
                .description("Getting a new laptop HP, with ram 16GB")
                .creationDate(new Date())
                .state(RequestState.OPEN)
                .owner(User.builder().id(1L).build())
                .stages(null)
                .build();

        Request createdRequest = requestRepository.save(request);

        Assertions.assertThat(createdRequest.getDescription()).isEqualTo("Getting a new laptop HP, with ram 16GB");
    }

    @Test
    public void getByIdTest(){
        Optional<Request> result = requestRepository.findById(1L);

        if(result.isPresent()){
            Request request = result.get();
            Assertions.assertThat(request.getSubject()).isEqualTo("New Laptop HP");
        }

    }

    @Test
    public void listTest(){
        List<Request> requests = requestRepository.findAll();

        Assertions.assertThat(requests.size()).isEqualTo(1);
    }

    @Test
    public void listByOwnerIdTest(){
        List<Request> requests = requestRepository.findAllByOwnerId(1L);

        Assertions.assertThat(requests.size()).isEqualTo(1);
    }

    @Test
    public void updateStatusTest(){
        int affectedRows = requestRepository.updateStatus(1L, RequestState.IN_PROGRESS);

        Assertions.assertThat(affectedRows).isEqualTo(1);
    }

}
