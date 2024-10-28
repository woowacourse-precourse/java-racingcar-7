package racingcar.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.controller.UserController;

@DisplayName("입력 값 검증 테스트")
class ValidatorTest {
    String n = "";

    @BeforeEach
    public void setUp() {
        for (int i = 0; i < 5100; i++) {
            n += "i";
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "  ", "      ", "\n", "\t"})
    @DisplayName("공백 입력 값 예외 테스트")
    void shouldThrowExceptionForBlankInput(String input) {
        UserController userController = new UserController(input);
        assertThatThrownBy(userController::initializeUsers)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {" , , ", "user1, ,user2", "user1,,user3"})
    @DisplayName("쉼표 기준 공백 입력 값 예외 테스트")
    void shouldThrowExceptionCommaInput(String input) {
        UserController userController = new UserController(input);
        assertThatThrownBy(userController::initializeUsers)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"user1;user2;user3", "user|name|list", "user1 user2 user3"})
    @DisplayName("잘못된 구분자 구분")
    void shouldThrowExceptionDelemeterInput(String input) {
        UserController userController = new UserController(n);
        assertThatThrownBy(userController::initializeUsers)
                .isInstanceOf(IllegalArgumentException.class);
    }

}
