package racingcar.model.car;

import org.junit.jupiter.api.Test;
import racingcar.config.AppConfig;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.model.movement.RandomMovement.MOVE_MIN_NUMBER;

class CarTest {
    private AppConfig appConfig = new AppConfig();

    @Test
    void 자동차_움직이기() {
        //given
        Car car = Car.of("user", appConfig.movement());

        //when
        assertRandomNumberInRangeTest(
                () -> {
                    car.move();
                },
                MOVE_MIN_NUMBER
        );

        //then
        assertThat(car.getPosition()).isEqualTo(1);
    }
}