package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class InputViewTest {

    private final InputStream originalIn = System.in;   // 원래의 System.in 저장

    @AfterEach
    void restoreSystemIn() {
        // 각 테스트 이후 원래 System.in 복원 및 Scanner 종료
        System.setIn(originalIn);
        Console.close();    // Scanner를 종료하여 초기화
    }

    @Test
    void 시도_횟수_양수_입력시_정상_작동() {
        String validInput = "5\n";
        InputStream inputStream = new ByteArrayInputStream(validInput.getBytes());
        System.setIn(inputStream);
        int moveNumber = InputView.readMoveNumber();
        assertEquals(5, moveNumber);
    }

    @Test
    void 시도_횟수_입력값이_문자일때_예외_발생() {
        try {
            String invalidInput = "five\n";
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
            String invalidInput = "0\n";
            InputStream inputStream = new ByteArrayInputStream(invalidInput.getBytes());
            System.setIn(inputStream);
            int moveNumber = InputView.readMoveNumber();
            fail("테스트에 실패하였습니다.");
        } catch (IllegalArgumentException e) {
            assertEquals("[ERROR] 시도 횟수는 양수만 입력 가능합니다.", e.getMessage());
        }
    }

}
