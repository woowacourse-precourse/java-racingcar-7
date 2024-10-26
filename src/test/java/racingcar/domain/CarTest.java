package racingcar.domain;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CarTest extends NsTest {
    @Test
    void 각_자동차에_이름을_부여할_수_있다() {
        Car car = new Car("김종경");
        assertThat(car.getName()).isEqualTo("김종경");
    }

    @Override
    protected void runMain() {

    }
}