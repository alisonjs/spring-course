package com.springcourse.domain;

import com.springcourse.domain.enums.RequestState;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Request {

    private Long id;

    private String subject;

    private String description;

    private Date creationDate;

    private RequestState state;

    private User user;

    private List<RequestStage> stages = new ArrayList<>();
}
