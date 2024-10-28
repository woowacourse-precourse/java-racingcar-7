package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AttemptCountTest {

    @Test
    @DisplayName("양의 정수가 입력되면 정상적으로 시도 횟수를 반환")
    void testValidPositiveIntegerInput() {
        String input = "5";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        int result = Application.getAttemptCount();

        assertEquals(5, result);
    }
}