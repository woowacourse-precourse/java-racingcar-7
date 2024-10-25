package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest extends NsTest {

    @Test
    void 차량_이름_글자수_제한() {
        assertSimpleTest(() ->
                assertThatThrownBy(()-> runException("abcdef", "5"))
                    .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 차량_초기화_확인() {
        Car car = new Car("pobi");

        assertThat(car.getCarName()).isEqualTo("pobi");
        assertThat(car.getPresentLocation()).isEqualTo(0);
    }

    @Test
    void 차량_전진_확인() {
        Car car = new Car("pobi");
        car.goForward();

        assertThat(car.getPresentLocation()).isEqualTo(1);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
