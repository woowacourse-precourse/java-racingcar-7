package racingcar;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static racingcar.MovingUnit.MOVING_FORWARD;
import static racingcar.MovingUnit.STOP;

class CarsTest {
    @Test
    void 자동차_이름_부여_테스트() {
        List<String> carNames = Arrays.asList("pobi", "woni");
        Cars cars = new Cars(carNames);
        Map<String, Boolean> carNamesMatchResult = cars.matchCarNames(carNames);

        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(carNamesMatchResult)
                    .containsEntry("pobi", true);
            softly.assertThat(carNamesMatchResult)
                    .containsEntry("woni", true);
        });
    }

    @Test
    void 자동차들_이동_테스트() {
        assertRandomNumberInRangeTest(() -> {
            List<String> carNames = Arrays.asList("pobi", "woni");
            Cars cars = new Cars(carNames);

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
            List<String> carNames = Arrays.asList("pobi", "woni");
            Cars cars = new Cars(carNames);

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