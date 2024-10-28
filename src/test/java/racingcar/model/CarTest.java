package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "\t", "\n"})
    @DisplayName("자동차 이름이 입력되지 않았으면 예외 발생")
    void isCarNameExist(String carName) {
        throwException(carName);
    }

    @ParameterizedTest
    @ValueSource(strings = {"longName", "onetwo"})
    @DisplayName("자동차 이름이 5자 초과이면 예외 발생")
    void carNameLengthError(String carName) {
        throwException(carName);
    }

    @ParameterizedTest
    @ValueSource(strings = {"플레이어", "pl@y"})
    @DisplayName("자동차 이름이 영문과 숫자 이외의 문자를 포함하면 예외 발생")
    void carNameFormatError(String carName) {
        throwException(carName);
    }

    @ParameterizedTest
    @ValueSource(strings = {"valid", "name"})
    @DisplayName("자동차 이름이 5자 이하이면 예외가 발생하지 않는다")
    void carNameWithValidLength(String carName) {
        notThrowException(carName);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Name", "P1", "p35"})
    @DisplayName("자동차 이름이 영문과 숫자로만 이루어지면 예외가 발생하지 않는다")
    void carNameWithValidFormat(String carName) {
        notThrowException(carName);
    }

    private void throwException(String carName) {
        assertThatThrownBy(() -> Car.createDefaultCar(carName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private void notThrowException(String carName) {
        assertThatCode(() -> Car.createDefaultCar(carName)).doesNotThrowAnyException();
    }


}