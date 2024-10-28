package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class RacingCarTest {

    @Test
    @DisplayName("잘못된 자동차 이름 입력 예외 테스트")
    void initTestWithInvalidCarName() {
        String input = "pobi,woni,junkyu";
        System.setIn(new java.io.ByteArrayInputStream(input.getBytes()));

        assertThrows(IllegalArgumentException.class, Application::init);
    }
}
