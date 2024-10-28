package racingcar.model;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RaceTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 0;

    @Test
    @DisplayName("랜덤값에 따라 전진하는 자동차 테스트")
    void operateRaceTest() {
        assertRandomNumberInRangeTest(() -> {
                    // Given: Car 배열과 시도횟수가 입력된 상황
                    List<Car> cars = List.of(new Car[]{new Car("sisu"), new Car("sumi"), new Car("kali")});
                    Race race = new Race(cars, 3);

                    // When: Race가 동작했을 시
                    race.operate();

                    // Then: 무작위 값이 4 이상이면 전진하고, 3 이하이면 전진하지 않는다.
                    assertThat(cars.stream().map(Car::getDistance).toList()).containsExactly(1, 2, 3);
                }, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, STOP, MOVING_FORWARD, MOVING_FORWARD, STOP, STOP,
                MOVING_FORWARD);
    }


}