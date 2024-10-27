package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputViewTest {

    private final InputHandler inputHandler = new InputHandler();
    private final InputView inputView = new InputView(inputHandler);

    @BeforeEach
    void setUp() {
        Console.close();
    }

    @Test
    @DisplayName("자동차 이름 입력 요청이 정상적으로 처리되는지 테스트")
    void requestCarNames_ValidInput_ReturnsList() {
        String input = "Alpha,Bravo,Choco";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        List<String> carNames = inputView.requestCarNames();

        assertThat(carNames)
                .hasSize(3)
                .containsExactly("Alpha", "Bravo", "Choco");
    }

    @Test
    @DisplayName("시도 횟수 입력이 정상적으로 처리되는지 테스트")
    void requestAttemptNumber_ValidInput_ReturnsInteger() {
        String input = "3";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        int attemptNumber = inputView.requestAttemptNumber();

        assertThat(attemptNumber).isEqualTo(3);
    }
}
