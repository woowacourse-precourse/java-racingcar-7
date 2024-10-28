package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.car.Car;
import racingcar.car.CarService;
import racingcar.race.RaceService;

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
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 전진_기능_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    List<Car> cars = List.of(new Car("kim"));

                    RaceService raceService = new RaceService();
                    raceService.race(cars);
                    assertThat(cars.get(0).getTotalMove()).isEqualTo(1);
                },
                MOVING_FORWARD
        );
    }

    @Test
    void 멈춤_기능_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    List<Car> cars = List.of(new Car("kim"));

                    RaceService raceService = new RaceService();
                    raceService.race(cars);
                    assertThat(cars.get(0).getTotalMove()).isEqualTo(0);
                },
                STOP
        );
    }

    @Test
    void 경주할_자동차_저장_기능_테스트() {
        assertSimpleTest(() -> {
            CarService carService = new CarService();
            assertThat(carService.createCar("kim,lee").size()).isEqualTo(2);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
