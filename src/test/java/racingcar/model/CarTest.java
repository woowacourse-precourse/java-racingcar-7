package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "\t", "\n"})
    @DisplayName("자동차 이름이 입력되지 않았으면 예외 발생")
    void isCarNameExist(String carName) {
        assertThatThrownBy(() -> new Car(carName, 0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"longName", "onetwo"})
    @DisplayName("자동차 이름이 5자 초과이면 예외 발생")
    void carNameLengthError(String carName) {
        assertThatThrownBy(() -> new Car(carName, 0))
                .isInstanceOf(IllegalArgumentException.class);
    }

}