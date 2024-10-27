package racingcar.model.dto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserDtoTest {

    private static final String carName = "테스트카";

    @Test
    @DisplayName("숫자가 아닌 횟수를 입력하면 예외를 발생시킨다.")
    void input_of() {
        String invalidInput = "숫자";
        String validInput = "5";

        Assertions.assertThatThrownBy(() -> UserDto.Input.of(carName, invalidInput))
                .isInstanceOf(IllegalArgumentException.class);

        Assertions.assertThat(UserDto.Input.of(carName, validInput).getCount())
                .isEqualTo(5);
    }

}