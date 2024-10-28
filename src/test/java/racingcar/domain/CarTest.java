package racingcar.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {
    @Test
    @DisplayName("이름")
    void testCarToString() {
        assertSimpleTest(()->{
            Car a = new Car("a");
            a.forward();
            a.forward();
            a.forward();
            assertThat(a.toPrettyString()).isEqualTo("a : ---");
        });
    }

}
