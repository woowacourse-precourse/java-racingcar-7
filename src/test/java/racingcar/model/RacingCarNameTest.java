package racingcar.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class RacingCarNameTest {

    @Test
    void 자동차_이름_중복_예외_테스트() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new RacingCarName(new String[]{""}).validateDuplicateNames(new String[]{"kim","lee","kim"}));
        assertEquals("자동차 이름이 중복되었습니다.", exception.getMessage());
    }
}
