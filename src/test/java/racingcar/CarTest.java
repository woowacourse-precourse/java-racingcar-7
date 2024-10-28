package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import camp.nextstep.edu.missionutils.test.NsTest;
import racingcar.generator.Num0Generator;
import racingcar.generator.Num4Generator;
import racingcar.model.Car;

public class CarTest extends NsTest {

    @Test
    void 전진_테스트() {
        assertSimpleTest(() -> {
            Car car = new Car("junki", new Num4Generator());
            car.move();
            assertThat(car.getPosition()).isEqualTo(1);
        });
    }

    @Test
    void 정지_테스트() {
        assertSimpleTest(() -> {
            Car car = new Car("junki", new Num0Generator());
            car.move();
            assertThat(car.getPosition()).isZero();
        });
    }

    @Test
    void 이름에_특수문자_예외_테스트() {
        assertThatThrownBy(() -> {
            Car car = new Car("jk@", new Num0Generator());
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이름_5글자_초과_예외_테스트() {
        assertThatThrownBy(() -> {
            Car car = new Car("junkiHeo", new Num0Generator());
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Override
    public void runMain() {
        Application.main(new String[] {});
    }
}
