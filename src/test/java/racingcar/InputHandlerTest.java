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

        assertEquals("자동차 이름은 1자 이상 5자 이하로 입력해야합니다.", exception.getMessage());
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

        assertEquals("시도 횟수는 1 이상의 정수여야합니다.", exception.getMessage());
    }

    @Test
    @DisplayName("시도 횟수가 숫자가 아닐 경우 예외 발생")
    void inputAttemptNumber_NotANumber_ThrowsException() {
        String input = "abc";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            inputHandler.inputAttemptNumber();
        });

        assertEquals("시도 횟수는 1 이상의 정수여야합니다.", exception.getMessage());
    }

    @Test
    @DisplayName("자동차 이름이 쉼표로 시작할 경우 예외 발생")
    void inputCarName_StartsWithComma_ThrowsException() {
        String input = ",Alpha,Bravo";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            inputHandler.inputCarName();
        });

        assertEquals("쉼표(,)로 시작하거나 끝날 수 없습니다.", exception.getMessage());
    }

    @Test
    @DisplayName("자동차 이름이 쉼표로 끝날 경우 예외 발생")
    void inputCarName_EndsWithComma_ThrowsException() {
        String input = "Alpha,Bravo,";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            inputHandler.inputCarName();
        });

        assertEquals("쉼표(,)로 시작하거나 끝날 수 없습니다.", exception.getMessage());
    }

    @Test
    @DisplayName("자동차 이름에 연속된 쉼표가 있을 경우 예외 발생")
    void inputCarName_ConsecutiveCommas_ThrowsException() {
        String input = "Alpha,,Bravo";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            inputHandler.inputCarName();
        });

        assertEquals("쉼표(,)가 연속으로 올 수 없습니다.", exception.getMessage());
    }

    @Test
    @DisplayName("중복된 자동차 이름이 있을 경우 예외 발생")
    void inputCarName_DuplicateNames_ThrowsException() {
        String input = "Alpha,Bravo,Alpha";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            inputHandler.inputCarName();
        });

        assertEquals("자동차 이름은 중복될 수 없습니다.", exception.getMessage());
    }

    @Test
    @DisplayName("시도 횟수가 int 범위를 초과할 경우 예외 발생")
    void inputAttemptNumber_ExceedsIntRange_ThrowsException() {
        String input = "999999999999999999999";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            inputHandler.inputAttemptNumber();
        });

        assertEquals("시도 횟수가 int 범위를 초과했습니다.", exception.getMessage());
    }

    @Test
    @DisplayName("시도 횟수 입력에 공백이 있어도 정상 처리")
    void inputAttemptNumber_WithSpaces_ReturnsInteger() {
        String input = " 5 ";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        int attemptNumber = inputHandler.inputAttemptNumber();

        assertEquals(5, attemptNumber);
    }
}
