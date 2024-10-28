package racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputTest {
    @Test
    @DisplayName("입력 도메인 테스트")
    void inputTest() {
        String testString = "testInput";
        Input input = new Input(testString);

        assertEquals(testString, input.getInput());
    }
}