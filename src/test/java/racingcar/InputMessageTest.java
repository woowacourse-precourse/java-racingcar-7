package racingcar;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputMessageTest {
    @Test
    public void 정상적으로_실행() {
        InputMessage inputMessage = new InputMessage();

        assertDoesNotThrow(() -> {
            inputMessage.splitCarName("a, ab, abc, abcd, abcde");
        });

        assertDoesNotThrow(() -> {
            inputMessage.splitCarName("a3, B2");
        });
    }

    @Test
    void 자동차_이름이_5자를_초과하지_않는_지_테스트(){
        InputMessage inputMessage = new InputMessage();

        assertThrows(IllegalArgumentException.class, () -> {
            inputMessage.splitCarName("abc, abcd, abcdef");
        });
    }

    @Test
    void 자동차_이름에_문자와_숫자만_들어있는_지_테스트(){
        InputMessage inputMessage = new InputMessage();

        assertThrows(IllegalArgumentException.class, () -> {
            inputMessage.splitCarName("abc, ab/");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            inputMessage.splitCarName("abc, ab d");
        });
    }
}
