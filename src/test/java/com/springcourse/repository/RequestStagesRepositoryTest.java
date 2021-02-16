package com.springcourse.repository;

import com.springcourse.domain.Request;
import com.springcourse.domain.RequestStage;
import com.springcourse.domain.User;
import com.springcourse.domain.enums.RequestState;
import org.assertj.core.api.Assertions;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest
public class RequestStagesRepositoryTest {
    @Autowired
    private RequestStageRepository repository;

    @Test
    public void saveTest(){
        RequestStage stage = RequestStage.builder()
                .id(null)
                .description("A new HP laptop was purchased with 16 GB ram")
                .state(RequestState.COSED)
                .realizationDate(new Date())
                .owner(User.builder().id(1L).build())
                .request(Request.builder().id(1L).build())
                .build();

        RequestStage createdRequestStage = repository.save(stage);
        Assertions.assertThat(createdRequestStage.getId()).isEqualTo(1L);

    }

    @Test
    public void getByIdTest(){
        Optional<RequestStage> result = repository.findById(1L);

        if(result.isPresent()){
            RequestStage stage = result.get();
            Assertions.assertThat(stage.getDescription()).isEqualTo("A new HP laptop was purchased with 16 GB ram");
        }

    }

    @Test
    public void listByRequestIdTest(){
        List<RequestStage> stages = repository.findAllByRequestId(1L);
        Assertions.assertThat(stages.size()).isEqualTo(1);
    }

}
