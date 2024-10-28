package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
        // given
        String validInput = "5\n";
        System.setIn(new ByteArrayInputStream(validInput.getBytes()));

        // when
        int moveNumber = InputView.readMoveNumber();

        // then
        assertEquals(5, moveNumber);
    }

    @Test
    void 시도_횟수_입력값이_문자일때_예외_발생() {
        // given
        String invalidInput = "five\n";
        System.setIn(new ByteArrayInputStream(invalidInput.getBytes()));

        // when, then
        assertThatThrownBy(InputView::readMoveNumber)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 시도 횟수는 양수만 입력 가능합니다.");
    }

    @Test
    void 시도_횟수_입력값이_0일때_예외_발생() {
        // given
        String invalidInput = "0\n";
        System.setIn(new ByteArrayInputStream(invalidInput.getBytes()));

        // when, then
        assertThatThrownBy(InputView::readMoveNumber)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 시도 횟수는 양수만 입력 가능합니다.");
    }

}
