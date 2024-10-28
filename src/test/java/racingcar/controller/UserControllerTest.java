package racingcar.controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.user.UserObject;

class UserControllerTest {
    private UserController userController;
    private final String inputString = "aaaa,bbbb,cccc,dddd";

    @BeforeEach
    void setUp() {
        userController = new UserController(inputString);
    }

    @Test
    @DisplayName("유저 이름이 쉼표로 구분되어 유저 객체 배열이 생성되는지 확인")
    void initializeUsers_ShouldCreateUserObjectsArray() {
        UserObject[] users = userController.initializeUsers();

        assertThat(users).isNotNull();
        assertThat(users).hasSize(4);

        assertThat(users[0].getUserName()).isEqualTo("aaaa");
        assertThat(users[1].getUserName()).isEqualTo("bbbb");
        assertThat(users[2].getUserName()).isEqualTo("cccc");
        assertThat(users[3].getUserName()).isEqualTo("dddd");
    }
}