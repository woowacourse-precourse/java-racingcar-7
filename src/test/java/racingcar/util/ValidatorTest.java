package racingcar.util;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.Test;

class ValidatorTest {

    @Test
    void 자동차_이름_빈_값_검사() {
        assertThrows(IllegalArgumentException.class, () -> Validator.checkCarNamesNotEmpty(""));
    }

    @Test
    void 자동차_이름_길이_검사() {
        List<String> names = List.of("pobi", "javaji");
        assertThrows(IllegalArgumentException.class, () -> Validator.checkCarNameLength(names));
    }

    @Test
    void 자동차_이름_중복_검사() {
        List<String> names = List.of("pobi", "pobi");
        assertThrows(IllegalArgumentException.class, () -> Validator.checkCarNamesUnique(names));
    }

    @Test
    void 시도_횟수_숫자_변환_검사() {
        assertThrows(IllegalArgumentException.class, () -> Validator.parseRoundCount("notNumber"));
    }

    @Test
    void 시도_횟수_양수_검사() {
        assertThrows(IllegalArgumentException.class, () -> Validator.checkRoundCountPositive(0));
    }
}
