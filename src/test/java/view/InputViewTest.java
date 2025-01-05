package view;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.Car;

class InputViewTest {

    InputView inputView;

    @BeforeEach
    void beforeAll() {
        inputView = new InputView();
    }

    @DisplayName("쉼표로 구분된 자동차명에 따라 자동차를 생성한다.")
    @ParameterizedTest
    @ValueSource(strings = {"aa,bb,cc", "1,2,3", "4"})
    void inputViewTest1(String carNames) {
        List<Car> cars = inputView.makeCars(carNames);
        assertThat(cars.size()).isEqualTo(carNames.split(",").length);
    }

    @DisplayName("빈값이 있거나 이름의 길이가 5자 이상 시 에러를 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"aa,,,cc", "", "aa,bb,abcdef,dd"})
    void inputViewTest2(String carNames) {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            List<Car> cars = inputView.makeCars(carNames);
        });
    }

    @DisplayName("시도 횟수를 입력받아 int로 변환한다")
    @ParameterizedTest
    @ValueSource(strings = {"1000000000", "1", "1234567"})
    void inputViewTest3(String inputCount) {
        int attemptCount = inputView.validCount(inputCount);
        assertThat(Integer.parseInt(inputCount)).isEqualTo(attemptCount);
    }

    @DisplayName("시도 횟수가 1~10억이 아닐경우 / 숫자가 아닐 경우 에러를 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"1000000001", "0", "-1", "11,22", "아아", "e", " ", ""})
    void inputViewTest4(String inputCount) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            inputView.validCount(inputCount);
        });
    }


}