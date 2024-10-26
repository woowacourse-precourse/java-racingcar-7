package racingcar;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class InputClassTest {

    InputClass inputClass = new InputClass();

    @Test
    @DisplayName("자동차의 전진조건을 결정하는 숫자 입력 테스트")
    void validateAttemptNumberTest() {
        String text = "five";
        String attemptNumber = "5";

        assertThatThrownBy(() -> inputClass.validateAttemptNumber(text))
                .isInstanceOf(IllegalArgumentException.class);
        assertThat(inputClass.validateAttemptNumber(attemptNumber))
                .isInstanceOf(Integer.class);
    }

    @Test
    @DisplayName("자동차 이름의 입력 길이 검증 기능. 6글자 이상일 경우, IllegalArgumentException 에러 발생 테스트")
    void validateCarNameLengthTest() {
        Car exceedNameCar = new Car("Lamborghini");
        Car car = new Car("car");
        int MAXIMUM_LIMIT_NAME_LENGTH = 5;

        assertThatThrownBy(() ->
                inputClass.validateCarNameLength(exceedNameCar.getCarName())).isInstanceOf(IllegalArgumentException.class);
        assertThat(car.getCarName().length()).isLessThan(MAXIMUM_LIMIT_NAME_LENGTH);
    }
}