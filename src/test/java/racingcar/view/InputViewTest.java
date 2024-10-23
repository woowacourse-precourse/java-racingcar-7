package racingcar.view;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class InputViewTest {

    @Test
    void 시도_횟수_양수_입력시_정상_작동() {
        String validInput = "5";
        InputStream inputStream = new ByteArrayInputStream(validInput.getBytes());
        System.setIn(inputStream);
        int moveNumber = InputView.readMoveNumber();
        assertEquals(5, moveNumber);
    }

    @Test
    void 시도_횟수_입력값이_문자일때_예외_발생() {
        try {
            String invalidInput = "five";
            InputStream inputStream = new ByteArrayInputStream(invalidInput.getBytes());
            System.setIn(inputStream);
            int moveNumber = InputView.readMoveNumber();
            fail("테스트에 실패하였습니다.");
        } catch (IllegalArgumentException e) {
            assertEquals("[ERROR] 시도 횟수는 양수만 입력 가능합니다.", e.getMessage());
        }
    }

    @Test
    void 시도_횟수_입력값이_0일때_예외_발생() {
        try {
            String invalidInput = "0";
            InputStream inputStream = new ByteArrayInputStream(invalidInput.getBytes());
            System.setIn(inputStream);
            int moveNumber = InputView.readMoveNumber();
            fail("테스트에 실패하였습니다.");
        } catch (IllegalArgumentException e) {
            assertEquals("[ERROR] 시도 횟수는 양수만 입력 가능합니다.", e.getMessage());
        }
    }

}
