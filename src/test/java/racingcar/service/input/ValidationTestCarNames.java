package racingcar.service.input;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValidationTestCarNames {

    @Test
    @DisplayName("긴 자동차명 입력 시 예외 발생 테스트")
    void longName() {
        String carName = "testCar";
        assertThatThrownBy(() -> Validation.carNames(carName)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("긴 자동차명을 포함하지 않는 긴 입력 시 예외 미발생 테스트")
    void justLongList() {
        String carName = "1,2,3,4,5,6,7";
        assertDoesNotThrow(() -> Validation.carNames(carName));
    }

    @Test
    @DisplayName("긴 자동차명 포함 시 예외 발생 테스트")
    void longNameContains() {
        String carName = "test,test123";
        assertThatThrownBy(() -> Validation.carNames(carName)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("구분자만 입력 시 예외 발생 테스트")
    void onlySeparator() {
        String carName = ",";
        assertThatThrownBy(() -> Validation.carNames(carName)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("유령 자동차 포함 시 예외 발생 테스트 중간")
    void ghostCar() {
        String carName = "1,2,,3";
        assertThatThrownBy(() -> Validation.carNames(carName)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("유령 자동차 포함 시 예외 발생 테스트 중간 다중")
    void ghostCar2() {
        String carName = "1,2,,,3";
        assertThatThrownBy(() -> Validation.carNames(carName)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("유령 자동차 포함 시 예외 발생 테스트 전방")
    void ghostCar3() {
        String carName = ",23";
        assertThatThrownBy(() -> Validation.carNames(carName)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("유령 자동차 포함 시 예외 발생 테스트 후방")
    void ghostCar4() {
        String carName = "23,";
        assertThatThrownBy(() -> Validation.carNames(carName)).isInstanceOf(IllegalArgumentException.class);
    }
}
