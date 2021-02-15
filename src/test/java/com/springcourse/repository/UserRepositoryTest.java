package com.springcourse.repository;

import com.springcourse.domain.User;
import com.springcourse.domain.enums.Role;
import org.assertj.core.api.Assertions;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void AsaveTest(){
        User user = User.builder()
                .id(null)
                .name("Alison")
                .email("alisonjs@outlook.com.br")
                .password("123")
                .requests(null)
                .role(Role.ADMINISTRATOR)
                .stages(null)
                .build();

        User createdUser = userRepository.save(user);
        Assertions.assertThat(createdUser.getId()).isEqualTo(1L);
    }

    @Test
    public void updateTest(){
        User user = User.builder()
                .id(1L)
                .name("Alison Silva")
                .email("alisonjs@outlook.com.br")
                .password("123")
                .requests(null)
                .role(Role.ADMINISTRATOR)
                .stages(null)
                .build();

        User updatedUser = userRepository.save(user);
        Assertions.assertThat(updatedUser.getName()).isEqualTo("Alison Silva");
    }

    @Test
    public void getByIdTest(){
        Optional<User> result = userRepository.findById(1L);
        User user = result.get();

        Assertions.assertThat(user.getPassword()).isEqualTo("123");
    }

    @Test
    public void listTest(){

        List<User> users = userRepository.findAll();

        Assertions.assertThat(users.size()).isEqualTo(1);

    }

    @Test
    public void loginTest(){
        Optional<User> result =  userRepository.login("alisonjs@outlook.com.br", "123");
        User loggedUser = result.get();

        Assertions.assertThat(loggedUser.getId()).isEqualTo(1L);
    }
}
