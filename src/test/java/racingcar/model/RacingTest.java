package racingcar.model;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class RacingTest {

    @Test
    void 이름_중복_예외() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> Racing.of("pobi,pobi"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> Racing.of("pobi,a,b,c,d,pobi"))
                    .isInstanceOf(IllegalArgumentException.class);
            ;
        });
    }
}
