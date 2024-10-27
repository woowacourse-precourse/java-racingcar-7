package racingcar.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TurnTest {
    @Test
    void 숫자를_입력하면_동작() {
        Turn turn = new Turn("1");
        assertEquals(1, turn.getTurn());
    }

    @Test
    void 문자를_입력하면_예외_발생() {
        assertThrows(IllegalArgumentException.class, () -> new Turn("test"));
    }

    @Test
    void 공백을_입력하면_에외_발생() {
        assertThrows(IllegalArgumentException.class, () -> new Turn(""));
    }

    @Test
    void 음수를_입력하면_에외_발생() {
        assertThrows(IllegalArgumentException.class, () -> new Turn("-1"));
    }
}