package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "\t", "\n"})
    @DisplayName("자동차 이름이 입력되지 않았으면 예외 발생")
    void isCarNameExist(String carName) {
        assertThatThrownBy(() -> new Car(carName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"longName", "onetwo"})
    @DisplayName("자동차 이름이 5자 초과이면 예외 발생")
    void carNameLengthError(String carName) {
        assertThatThrownBy(() -> new Car(carName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"valid", "name"})
    @DisplayName("자동차 이름이 5자 이하이면 예외가 발생하지 않는다")
    void carNameWithValidLength(String carName) {
        assertThatCode(() -> new Car(carName)).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings = {"플레이어", "pl@y"})
    @DisplayName("자동차 이름이 영문과 숫자 이외의 문자를 포함하면 예외 발생")
    void carNameFormatError(String carName) {
        assertThatThrownBy(() -> new Car(carName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Name", "P1", "p35"})
    @DisplayName("자동차 이름이 영문과 숫자로만 이루어지면 예외가 발생하지 않는다")
    void carNameWithValidFormat(String carName) {
        assertThatCode(() -> new Car(carName)).doesNotThrowAnyException();
    }

}