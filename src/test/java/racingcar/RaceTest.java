package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.*;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

class RaceTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 경주_실행_결과_테스트() {
        List<Car> cars = Arrays.asList(new Car("car1"), new Car("car2"));
        Race race = new Race(cars, 1);
        assertRandomNumberInRangeTest(
            () -> {
                race.startRace();
                assertThat(output()).contains("car1 : -", "car2 :");
            },
            MOVING_FORWARD, STOP
        );
    }

    @Test
    void 우승자_결정_테스트() {
        List<Car> cars = Arrays.asList(new Car("car1"), new Car("car2"));
        Race race = new Race(cars, 2);

        cars.get(0).move();
        cars.get(1).move();
        cars.get(0).move();

        List<String> winners = race.getWinners();
        assertThat(winners).contains("car1");
    }

    @Override
    public void runMain() {
        // 메인 메소드 X
    }
}
