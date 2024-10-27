package racingcar.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class NameTest {
    @Test
    void 자동차_이름은_5자_보다_크면_예외_발생() {
        String name = "daesun";
        Assertions.assertThrows(IllegalArgumentException.class, () -> Name.from(name));
    }

    @ParameterizedTest
    @NullAndEmptySource
    void 자동차_이름이_빈문자열이거나_null일경우_예외_발생(String name){
        Assertions.assertThrows(IllegalArgumentException.class, () -> Name.from(name));
    }
}