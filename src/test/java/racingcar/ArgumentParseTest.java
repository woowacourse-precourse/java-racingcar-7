package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class ArgumentParseTest {
    @Test
    @DisplayName("5글자 초과")
    public void testFiveOver() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            GameConfigParser.parseCarNames("123456");
        });
    }

    @Test
    @DisplayName("자동차 이름 입력 안함")
    public void testNoName() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            GameConfigParser.parseCarNames("");
        });
    }

    @Test
    @DisplayName("자동차 이름 빈 칸 입력")
    public void testEmptyName() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            GameConfigParser.parseCarNames(", , ");
        });
    }

    @Test
    @DisplayName("턴 수 음수 입력")
    public void testNegativeTurn() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            GameConfigParser.parseNumberOfTurn("-1");
        });
    }
}
