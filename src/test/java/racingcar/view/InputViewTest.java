package racingcar.view;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputViewTest {

    private void setInput(String input) {
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
    }

    @AfterEach
    void closeConsole() {
        Console.close();
    }

    @Test
    @DisplayName("자동차 이름 목록 입력 예외 테스트 - 빈 문자열")
    void emptyInput() {
        String input = " ";
        setInput(input);

        assertThrows(IllegalArgumentException.class, InputView::inputCarName);
    }

    @Test
    @DisplayName("자동차 이름 목록 입력 예외 테스트 - 쉼표가 없는 경우(경주 자동차가 오직 1대)")
    void onlyOneCarName() {
        String input = "car1car2";
        setInput(input);

        assertThrows(IllegalArgumentException.class, InputView::inputCarName);
    }

    @Test
    @DisplayName("자동차 이름 목록 정상 입력 테스트")
    void createValidName() {
        String input = "car1,car2";
        setInput(input);

        String result = InputView.inputCarName();

        assertEquals(input, result);
    }

    @Test
    void validTryCount() {
        String input = "5";
        setInput(input);

        int result = InputView.inputTryCount();

        assertEquals(5, result);
    }

    @ParameterizedTest
    @DisplayName("시도 횟수 예외 테스트")
    @ValueSource(strings = {"0", "abc"})
    void invalidTryCount(String input) {
        setInput(input);

        assertThrows(IllegalArgumentException.class, InputView::inputTryCount);
    }
}
