package racingcar.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.car.Car;

public class CarTest {

    private static final int MAX_LENGTH_OF_NAME = 5;

    @Test
    @DisplayName("자동차의 이름이 최대 길이를 넘으면 예외를 던진다")
    public void throwExceptionWhenLengthOfCarNameExceedsFive() {
        // given
        String invalidName = "A".repeat(MAX_LENGTH_OF_NAME + 1);

        // when & then
        assertThatThrownBy(() -> new Car(invalidName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessages.Car.LENGTH_OF_NAME_EXCEED);
    }
}
