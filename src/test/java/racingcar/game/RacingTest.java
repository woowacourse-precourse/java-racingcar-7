package racingcar.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

class RacingTest {

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @DisplayName("단일 우승자 검증")
    @Test
    void validateSingleWinner() {
        //given
        List<Car> cars = CarFactory.createCars("pobi,woni");
        Racing racing = new Racing(cars, 1);

        assertRandomNumberInRangeTest(
                () -> {
                    // when
                    racing.start();

                    // then
                    List<Car> winners = racing.getWinners();
                    assertThat(winners).hasSize(1);
                    assertThat(winners.get(0).getName()).isEqualTo("pobi");
                },
                MOVING_FORWARD, STOP
        );
    }

    @DisplayName("다중 우승자 검증")
    @Test
    void validateMultipleWinner() {
        // given
        List<Car> cars = CarFactory.createCars("pobi,woni,jun");
        Racing racing = new Racing(cars, 1);

        assertRandomNumberInRangeTest(
                () -> {
                    // when
                    racing.start();

                    // then
                    List<Car> winners = racing.getWinners();
                    assertThat(winners).hasSize(2);
                    assertThat(winners.get(0).getName()).isEqualTo("pobi");
                    assertThat(winners.get(1).getName()).isEqualTo("woni");
                },
                MOVING_FORWARD, MOVING_FORWARD, STOP
        );
    }

    @DisplayName("이동 상태 검증")
    @Test
    void validateMove() {
        // given
        List<Car> cars = CarFactory.createCars("pobi");
        Racing racing = new Racing(cars, 2);

        assertRandomNumberInRangeTest(
                () -> {
                    // when
                    racing.start();

                    // then
                    assertThat(cars.get(0).getPosition()).isEqualTo(1);
                },
                MOVING_FORWARD, STOP
        );
    }
}
