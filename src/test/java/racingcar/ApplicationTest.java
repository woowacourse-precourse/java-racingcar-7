package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import java.util.*;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 기능_테스트() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "1");
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
            },
            MOVING_FORWARD, STOP
        );
    }

    @Test
    void Car_move_테스트() {
        Car car = new Car("pobi");
        car.move();
        if (car.getPosition() == 0) {
            assertThat(car.getPosition()).isEqualTo(0);
        } else {
            assertThat(car.getPosition()).isEqualTo(1);
        }
    }

    @Test
    void PlayingCarFactory_createCars_테스트() {
        Set<String> cars = new LinkedHashSet<>();
        cars.add("pobi");
        cars.add("woni");
        Set<Car> playingCars = PlayingCarFactory.createCars(cars);
        assertThat(playingCars).hasSize(2);
        assertThat(playingCars).extracting("name").containsExactly("pobi", "woni");
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
