package racingcar.view;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputViewTest {
    private final InputStream initialInput = System.in;

    @BeforeEach
    void resetInput() {
        System.setIn(initialInput);
    }

    @Test
    @DisplayName("자동차 이름 목록 입력 예외 테스트 - 빈 문자열")
    void createInValidName_EmptyInput() {
        String simulatedInput = " ";
        ByteArrayInputStream testInput = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(testInput);

        assertThrows(IllegalArgumentException.class, InputView::inputCarName);
    }

    @Test
    @DisplayName("자동차 이름 목록 입력 예외 테스트 - 쉼표가 없는 경우")
    void createInValidName_NoComma() {
        String simulatedInput = "car1car2";
        ByteArrayInputStream testInput = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(testInput);

        assertThrows(IllegalArgumentException.class, InputView::inputCarName);
    }

    @Test
    @DisplayName("자동차 이름 목록 정상 입력 테스트")
    void createValidName() {
        String simulatedInput = "car1,car2";
        ByteArrayInputStream testInput = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(testInput);

        String result = InputView.inputCarName();

        assertEquals(simulatedInput, result);
    }
}
