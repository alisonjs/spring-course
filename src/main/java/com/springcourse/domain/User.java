package com.springcourse.domain;


import com.springcourse.domain.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    private Long id;

    private String name;

    private String email;

    private String password;

    private Role role;

    private List<Request> requests = new ArrayList<>();

    private List<RequestStage> stages = new ArrayList<>();
}
