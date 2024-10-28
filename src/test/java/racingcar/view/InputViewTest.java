package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class InputViewTest {

    private final InputStream originalIn = System.in;

    @AfterEach
    void restoreSystemIn() {
        System.setIn(originalIn);
    }

    private void setSystemIn(String input) {
        Console.close();
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    @Test
    @DisplayName("자동차 이름을 입력받고 파싱하는 기능 테스트")
    void testGetCarNames() {
        setSystemIn("pobi,crong,honux\n");

        InputView inputView = new InputView();
        List<String> carNames = inputView.getCarNames();

        assertEquals(List.of("pobi", "crong", "honux"), carNames);
    }

    @Test
    @DisplayName("자동차 이름이 5자 초과일 경우 예외 발생")
    void testCarNameLengthValidation() {
        setSystemIn("pobi,crongggg,honux\n");

        InputView inputView = new InputView();

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                inputView::getCarNames
        );
        assertEquals("자동차 이름은 5자 이하여야 합니다.", exception.getMessage());
    }

    @Test
    @DisplayName("시도 횟수 입력받고 검증하는 기능 테스트")
    void testGetTryCount() {
        setSystemIn("5\n");

        InputView inputView = new InputView();
        int tryCount = inputView.getTryCount();

        assertEquals(5, tryCount);
    }

    @Test
    @DisplayName("시도 횟수가 0 이하일 경우 예외 발생")
    void testTryCountMinimumValidation() {
        setSystemIn("0\n");

        InputView inputView = new InputView();

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                inputView::getTryCount
        );
        assertEquals("시도 횟수는 1회 이상이어야 합니다.", exception.getMessage());
    }

    @Test
    @DisplayName("시도 횟수가 숫자가 아닌 경우 예외 발생")
    void testTryCountFormatValidation() {
        setSystemIn("five\n");

        InputView inputView = new InputView();

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                inputView::getTryCount
        );
        assertEquals("시도 횟수는 숫자여야 합니다.", exception.getMessage());
    }
}
