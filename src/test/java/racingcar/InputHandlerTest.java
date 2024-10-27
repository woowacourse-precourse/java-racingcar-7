package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputHandlerTest {

    private final InputHandler inputHandler = new InputHandler();

    @BeforeEach
    void setUp() {
        Console.close();
    }


    @Test
    @DisplayName("유효한 이름들을 입력했을때 List 반환")
    void inputCarName_ValidNames_ReturnsList() {
        String input = "Alpha, Bravo, Choco, Delta";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        List<String> carNames = inputHandler.inputCarName();

        assertEquals(4, carNames.size());
        assertEquals("Alpha", carNames.get(0));
        assertEquals("Bravo", carNames.get(1));
        assertEquals("Choco", carNames.get(2));
        assertEquals("Delta", carNames.get(3));
    }

    @Test
    @DisplayName("유효하지 않은 이름을 입력했을때 예외 발생")
    void inputCarName_InvalidNames_ReturnsList() {
        String input = "Alpha, Bravo, Charlie, Delta";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            inputHandler.inputCarName();
        });

        assertEquals("자동차 이름은 1자 이상 5자 이하로 입력해야 합니다.", exception.getMessage());
    }

    @Test
    @DisplayName("시도 횟수가 양의 정수일때 성공적으로 반환")
    void inputAttemptNumber_ValidNumber_ReturnsInteger() {
        String input = "3";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        int attemptNumber = inputHandler.inputAttemptNumber();

        assertEquals(3, attemptNumber);
    }

    @Test
    @DisplayName("시도 횟수가 0 이하일 경우 예외 발생")
    void inputAttemptNumber_NonPositiveNumber_ThrowsException() {
        String input = "0";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            inputHandler.inputAttemptNumber();
        });

        assertEquals("시도 횟수는 1 이상의 숫자여야 합니다.", exception.getMessage());
    }

    @Test
    @DisplayName("시도 횟수가 숫자가 아닐 경우 예외 발생")
    void inputAttemptNumber_NotANumber_ThrowsException() {
        String input = "abc";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            inputHandler.inputAttemptNumber();
        });

        assertEquals("시도 횟수는 1 이상의 숫자여야 합니다.", exception.getMessage());
    }
}
