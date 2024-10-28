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

            cars.moveCars();

            assertCarsAtPositions(cars.getCars(), 1, 0);
        }, MOVING_FORWARD, STOP);
    }

    private Cars createGivenCars() {
        String carName = "pobi,woni";
        return new Cars(carName);
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