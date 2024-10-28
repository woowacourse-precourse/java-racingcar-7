package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.Car;
import racingcar.Racing;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

public class RacingTest {

    private Racing racing;

    @BeforeEach
    void setUp() {
        racing = new Racing();
    }

    @Test
    void 자동차_설정_테스트() {
        String input = "자동차1,자동차2,자동차3";

        racing.setupCars(input);
        List<Car> cars = racing.getCars();

        assertThat(cars).hasSize(3);
        assertThat(cars.get(0).getName()).isEqualTo("자동차1");
        assertThat(cars.get(1).getName()).isEqualTo("자동차2");
        assertThat(cars.get(2).getName()).isEqualTo("자동차3");

    }

    @Test
    void 전진_라운드_테스드() {
        racing.setupCars("자동차1,자동차2,자옫차3");
        List<Car> cars = racing.getCars();

        assertRandomNumberInRangeTest(
                () -> {
                    racing.performRaceRound(cars);

                    assertThat(cars.stream().anyMatch(car -> car.getPosition() > 0)).isTrue();
                },
                4,3,3
        );
    }

    @Test
    void 우승자_결정_테스트() {
        racing.setupCars("자동차1,자동차2");
        List<Car> cars = racing.getCars();

        cars.get(0).moveForward();

        String winners = racing.getWinners();

        assertThat(winners).isEqualTo("자동차1");
    }

    @Test
    void 공동_우승자_결정_테스트() {
        racing.setupCars("자동차1,자동차2");
        List<Car> cars = racing.getCars();

        cars.get(0).moveForward();
        cars.get(1).moveForward();

        String winners = racing.getWinners();

        assertThat(winners).isEqualTo("자동차1, 자동차2");
    }

    @Test
    void 전진한_자동차가_없을_때_출력_테스트() {

        racing.setupCars("자동차1,자동차2");
        List<Car> cars = racing.getCars();

        String winners = racing.getWinners();

        assertThat(winners).isEqualTo("전진한 자동차가 없습니다.");


    }
}
