package racingcar.view;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InputViewTest {
    @Test
    public void 테스트_시도_횟수_입력_유효성_검사() {
        String input = "-1";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, InputView::getTrialCount);
        assertEquals("시도 횟수는 1 이상이어야 합니다.", thrown.getMessage());
    }
}
