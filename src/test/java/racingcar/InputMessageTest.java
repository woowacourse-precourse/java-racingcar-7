package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputMessageTest {
    @Test
    void 자동차_이름이_5자를_초과하지_않는_지_테스트(){
        InputMessage inputMessage = new InputMessage();

        assertThrows(IllegalArgumentException.class, () -> {
            inputMessage.splitCarName("abc, abcd, abcdef");
        });
    }
}
