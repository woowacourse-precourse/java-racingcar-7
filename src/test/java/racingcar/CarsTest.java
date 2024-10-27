package racingcar;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static racingcar.MovingUnit.MOVING_FORWARD;
import static racingcar.MovingUnit.STOP;

class CarsTest {
    @Test
    void 자동차들_이동_테스트() {
        assertRandomNumberInRangeTest(() -> {
            String carName = "pobi,woni";
            CarNames carNames = new CarNames(carName);
            Cars cars = new Cars(carNames.createCars());

            List<Car> racingCars = cars.moveCars();

            SoftAssertions.assertSoftly((softly) -> {
                softly.assertThat(racingCars.get(0).isPosition(1))
                        .isTrue();
                softly.assertThat(racingCars.get(1).isPosition(0))
                        .isTrue();
            });
        }, MOVING_FORWARD, STOP);
    }

    @Test
    void 자동차들_횟수_많은_이동_테스트() {
        assertRandomNumberInRangeTest(() -> {
            String carName = "pobi,woni";
            CarNames carNames = new CarNames(carName);
            Cars cars = new Cars(carNames.createCars());

            cars.moveCars();
            cars.moveCars();
            List<Car> racingCars = cars.moveCars();

            SoftAssertions.assertSoftly((softly) -> {
                softly.assertThat(racingCars.get(0).isPosition(3))
                        .isTrue();
                softly.assertThat(racingCars.get(1).isPosition(1))
                        .isTrue();
            });
        }, MOVING_FORWARD, STOP, MOVING_FORWARD, STOP, MOVING_FORWARD, MOVING_FORWARD);
    }
}