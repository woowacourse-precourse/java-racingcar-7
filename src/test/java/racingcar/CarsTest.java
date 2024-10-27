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
    void 횟수가_1_일떄_자동차_경주게임_기능_테스트() {
        assertRandomNumberInRangeTest(() -> {
            List<String> carNames = Arrays.asList("pobi", "woni");
            Cars cars = new Cars(carNames);
            int raceTime = 1;

            List<List<Car>> raceRecords = cars.race(raceTime);
            List<Car> firstRecord = raceRecords.get(0);

            SoftAssertions.assertSoftly((softly) -> {
                softly.assertThat(firstRecord.get(0).isPosition(1))
                        .isTrue();
                softly.assertThat(firstRecord.get(1).isPosition(0))
                        .isTrue();
            });
        }, MOVING_FORWARD, STOP);
    }

    @Test
    void 횟수가_2이상_일떄_횟수별로_자동차_경주게임_기능_테스트() {
        assertRandomNumberInRangeTest(() -> {
            List<String> carNames = Arrays.asList("pobi", "woni");
            Cars cars = new Cars(carNames);
            int raceTime = 3;

            List<List<Car>> raceRecords = cars.race(raceTime);
            List<Car> firstRecord = raceRecords.get(0);
            List<Car> secondRecord = raceRecords.get(1);
            List<Car> thirdRecord = raceRecords.get(2);

            SoftAssertions.assertSoftly((softly) -> {
                softly.assertThat(firstRecord.get(0).isPosition(1))
                        .isTrue();
                softly.assertThat(firstRecord.get(1).isPosition(0))
                        .isTrue();
                softly.assertThat(secondRecord.get(0).isPosition(2))
                        .isTrue();
                softly.assertThat(secondRecord.get(1).isPosition(1))
                        .isTrue();
                softly.assertThat(thirdRecord.get(0).isPosition(3))
                        .isTrue();
                softly.assertThat(thirdRecord.get(1).isPosition(1))
                        .isTrue();
            });
        }, MOVING_FORWARD, STOP, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, STOP);
    }
}