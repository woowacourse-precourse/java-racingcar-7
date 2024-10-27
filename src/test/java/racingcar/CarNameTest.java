package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.message.ErrorMessage;
import racingcar.model.Car;
import racingcar.validator.CarNameValidator;

public class CarNameTest {

    @Test
    @DisplayName("자동차 이름 검증 실패 테스트")
    void carNameFailTest_emptyString() {
        // given
        String CarName = "";

        // when
        Assertions.assertThatThrownBy(() ->
                        CarNameValidator.validateCarNameFormat(CarName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NON_ALPHA_MESSAGE);
    }

    @Test
    @DisplayName("자동차 이름 검증 실패 테스트 - 숫자")
    void carNameFailTest_numericOnly() {
        // given
        String CarName = "123";

        // when
        Assertions.assertThatThrownBy(() ->
                        CarNameValidator.validateCarNameFormat(CarName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NON_ALPHA_MESSAGE);
    }

    @Test
    @DisplayName("자동차 이름 검증 실패 테스트 - 특수문자")
    void carNameFailTest_specialCharacters() {
        // given
        String CarName = "!!@@";

        // when
        Assertions.assertThatThrownBy(() ->
                        CarNameValidator.validateCarNameFormat(CarName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NON_ALPHA_MESSAGE);
    }

    @Test
    @DisplayName("자동차 이름 생성 성공 테스트")
    void carNameSuccessTest() {
        // given
        String CarName = "pobi";

        // when
        Car car = new Car(CarName);

        // then
        Assertions.assertThat(car.getName()).isEqualTo(CarName);
    }

    @Test
    @DisplayName("자동차 이름이 5자를 초과하는 경우 예외 발생 테스트")
    void carNameLengthFailTest() {
        // given
        String CarName = "toolongname";

        // when
        Assertions.assertThatThrownBy(() ->
                        CarNameValidator.validateCarNameLength(CarName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_CAR_NAME_MESSAGE);
    }
}
