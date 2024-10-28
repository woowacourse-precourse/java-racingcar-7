package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.util.validator.ErrorMessage.INPUT_CAR_NAME_BLANK;
import static racingcar.util.validator.ErrorMessage.INPUT_CAR_NAME_IS_INCORRECT;
import static racingcar.util.validator.ErrorMessage.INPUT_STRING_DUPLICATE;
import static racingcar.util.validator.ErrorMessage.INPUT_STRING_NOT_NULL;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Application;

import java.util.Arrays;
import java.util.List;
import racingcar.util.validator.CarNameValidator;

public class CarTest {

    @Test
    @DisplayName("차 이름이 5글자 이상일 때 예외가 발생한다.")
    void carNameMoreThan5CharactersExceptionsHandling() {
        assertThatThrownBy(() -> CarNameValidator.checkOverRange("자동차입니다"))
                .isInstanceOf(RuntimeException.class)
                .hasMessage(INPUT_CAR_NAME_IS_INCORRECT.message);
    }

    @Test
    @DisplayName("차 이름에 공백만 들어갔을 때 예외가 발생한다.")
    void carNameBlankExceptionHandling() {
        assertThatThrownBy(() -> CarNameValidator.checkSpace(" "))
                .isInstanceOf(RuntimeException.class)
                .hasMessage(INPUT_CAR_NAME_BLANK.message);
    }

    @Test
    @DisplayName("차 이름이 안 들어갔을 때 예외가 발생한다.")
    void carNameNullExceptionsHandling() {
        assertThatThrownBy(() -> CarNameValidator.checkEmpty((String) null))
                .isInstanceOf(RuntimeException.class)
                .hasMessage(INPUT_STRING_NOT_NULL.message);
    }

    @Test
    @DisplayName("차 이름이 겹칠 때 예외가 발생한다.")
    void carNamesOverlapExceptionsHandling() {
        List<String> carNames = Arrays.asList("인호", "인호");
        assertThatThrownBy(() -> CarNameValidator.checkDuplicate(carNames))
                .isInstanceOf(RuntimeException.class)
                .hasMessage(INPUT_STRING_DUPLICATE.message);
    }

    @Test
    @DisplayName("랜덤 값이 4 이상이면 1 전진")
    void carMove() {
        // given
        Car car = new Car("test");

        // when
        car.carMove(4);

        // then
        assertThat(car).extracting("position").isEqualTo(1);
    }

    @Test
    @DisplayName("랜덤 값이 4 미만이면 멈춤")
    void carStop() {
        // given
        Car car = new Car("test");

        // when
        car.carMove(3);

        // then
        assertThat(car).extracting("position").isEqualTo(0);
    }
}
