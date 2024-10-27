package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.ByteArrayInputStream;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputHandlerTest {

    private final InputHandler inputHandler = new InputHandler();

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
}
