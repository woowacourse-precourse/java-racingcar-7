package racingcar.unittest;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Car;
import racingcar.Race;

class RaceTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    @DisplayName("Race 실행 시 자동차가 이동하는지 테스트")
    void startRace_carsShouldMove() {
        assertRandomNumberInRangeTest(
                () -> {
                    // Given
                    Car car1 = new Car("pobi");
                    Car car2 = new Car("crong");
                    List<Car> cars = Arrays.asList(car1, car2);
                    int attempts = 1;

                    Race race = new Race(cars, attempts);

                    // When
                    race.start();

                    // Then
                    assertThat(car1.getPosition()).isEqualTo(1); // 전진
                    assertThat(car2.getPosition()).isEqualTo(0); // 정지
                },
                MOVING_FORWARD, STOP
        );
    }

    @Override
    public void runMain() {
    }
}
