package racingcar.view;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.IllegalArgumentException;

class InputViewTest {

    private InputView inputView;

    @BeforeEach
    void init() {
        inputView = new InputView();
    }

    @Test
    @DisplayName("자동차 문자열 입력 테스트")
    void readCarNamesTest() {
        String input = setInput("pobi,woni,jun");

        String carNames = inputView.readCarNames();

        assertThat(carNames).isEqualTo(input);
    }

    @Test
    @DisplayName("시도 횟수 입력")
    void readTryCount() {
        String input = setInput("1");

        int readTryCount = inputView.readTryCount();

        assertThat(readTryCount).isEqualTo(Integer.parseInt(input));
    }

    @Test
    @DisplayName("잘못된 문자열 입력시 예외 발생")
    void invalidStringInputThrowsException() {
        setInput("one");

        assertThatThrownBy(() -> inputView.readTryCount())
                .hasMessage("시도 횟수는 숫자여야 합니다.")
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("시도횟수가 음수일이 예외 발생")
    void negativeTryCountThrowsException() {
        setInput("-1");

        assertThatThrownBy(() -> inputView.readTryCount())
                .hasMessage("시도 횟수는 0 이상의 숫자여야 합니다.")
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static String setInput(String value) {
        ByteArrayInputStream in = new ByteArrayInputStream(value.getBytes());
        System.setIn(in);
        return value;
    }
}