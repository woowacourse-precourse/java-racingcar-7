package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.CarNames.createCarNames;
import static racingcar.WinnerCalculator.calculateWinners;

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
    void 공동_우승자_기능_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    void 자동차_이름_분리_테스트() {
        String carName = "pobi,woni";
        List<String> expectedCarNames = Arrays.asList("pobi", "woni");

        assertThat(createCarNames(carName)).isEqualTo(expectedCarNames);
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 자동차_이름_부여_테스트() {
        List<String> carNames = Arrays.asList("pobi", "woni");
        Cars cars = new Cars(carNames);
        Map<String, Boolean> carNamesMatchResult = cars.isCarsName(carNames);

        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(carNamesMatchResult)
                    .containsEntry("pobi", true);
            softly.assertThat(carNamesMatchResult)
                    .containsEntry("woni", true);
        });
    }

    @Test
    void 자동차_4미만_전진불가_기능_테스트() {
        assertRandomNumberInRangeTest(() -> {
            Car car = new Car("pobi");
            int expectedPosition = 0;
            Car movingCar = car.move();

            assertThat(movingCar.isPosition(expectedPosition)).isTrue();
        }, STOP);
    }

    @Test
    void 자동차_4이상_전진_기능_테스트() {
        assertRandomNumberInRangeTest(() -> {
            Car car = new Car("pobi");
            int expectedPosition = 1;
            Car movingCar = car.move();

            assertThat(movingCar.isPosition(expectedPosition)).isTrue();
        }, MOVING_FORWARD);
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

    @Test
    void 단독_우승자_계산_기능_테스트() {
        assertRandomNumberInRangeTest(() -> {
            List<String> carNames = Arrays.asList("pobi", "woni");
            Cars cars = new Cars(carNames);
            int raceTime = 3;

            List<List<Car>> racingRecords = cars.race(raceTime);
            List<Car> lastRacingRecord = racingRecords.getLast();

            List<String> expectedWinners = List.of("pobi");

            assertThat(calculateWinners(lastRacingRecord)).isEqualTo(expectedWinners);
        }, MOVING_FORWARD, STOP, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, STOP);
    }

    @Test
    void 공동_우승자_계산_기능_테스트() {
        assertRandomNumberInRangeTest(() -> {
            List<String> carNames = Arrays.asList("pobi", "woni");
            Cars cars = new Cars(carNames);
            int raceTime = 1;

            List<List<Car>> racingRecords = cars.race(raceTime);
            List<Car> lastRacingRecord = racingRecords.getLast();

            List<String> expectedWinners = Arrays.asList("pobi", "woni");

            assertThat(calculateWinners(lastRacingRecord)).isEqualTo(expectedWinners);
        }, MOVING_FORWARD, MOVING_FORWARD);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
