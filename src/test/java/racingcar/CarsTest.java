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
            Cars cars = createGivenCars();

            List<Car> racingCars = cars.moveCars();

            assertCarsAtPositions(racingCars, 1, 0);
        }, MOVING_FORWARD, STOP);
    }

    @Test
    void 자동차들_횟수_많은_이동_테스트() {
        assertRandomNumberInRangeTest(() -> {
            Cars cars = createGivenCars();

            cars.moveCars();
            cars.moveCars();
            List<Car> racingCars = cars.moveCars();

            assertCarsAtPositions(racingCars, 3, 1);
        }, MOVING_FORWARD, STOP, MOVING_FORWARD, STOP, MOVING_FORWARD, MOVING_FORWARD);
    }

    private Cars createGivenCars() {
        String carName = "pobi,woni";
        CarNames carNames = new CarNames(carName);
        return new Cars(carNames.createCars());
    }

    private void assertCarsAtPositions(List<Car> racingCars, int firstCarGivenPosition, int secondCarGivenPosition) {
        SoftAssertions.assertSoftly((softly) -> {
            softly.assertThat(racingCars.get(0).isPosition(firstCarGivenPosition))
                    .isTrue();
            softly.assertThat(racingCars.get(1).isPosition(secondCarGivenPosition))
                    .isTrue();
        });
    }
}