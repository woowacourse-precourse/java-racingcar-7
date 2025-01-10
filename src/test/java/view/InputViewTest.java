package view;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputViewTest {

    InputView inputView;

    @BeforeEach
    void beforeAll() {
        inputView = new InputView();
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
