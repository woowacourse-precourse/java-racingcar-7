package racingcar.view;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputTest {
    @AfterEach
    void closeConsole() {
        Console.close();
    }

    @DisplayName("예외 테스트: 잘못된 문자열 형식의 자동차 이름 입력 점검")
    @ParameterizedTest
    @ValueSource(strings = {"\n", " ", "Mary,John,John", "8,Paul"})
    void requestCarNames_throwIllegalArgumentException(String userInput) {
        System.setIn(new ByteArrayInputStream(userInput.getBytes()));
        Input input = new Input();

        assertThatThrownBy(() -> input.requestCarNames())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("예외 테스트: 잘못된 숫자값 형식의 시도 횟수 입력 점검")
    @ParameterizedTest
    @ValueSource(strings = {"\n", " ", "-1", "0", "1.15", "one"})
    void requestRaceRounds_throwIllegalArgumentException(String userInput) {
        System.setIn(new ByteArrayInputStream(userInput.getBytes()));
        Input input = new Input();

        assertThatThrownBy(() -> input.requestRaceRounds())
                .isInstanceOf(IllegalArgumentException.class);
    }
}