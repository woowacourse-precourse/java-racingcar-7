package racingcar.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class NameTest {
    @Test
    void 자동차_이름은_5자_보다_크면_예외_발생() {
        String name = "daesun";
        Assertions.assertThrows(IllegalArgumentException.class, () -> Name.from(name));
    }
}