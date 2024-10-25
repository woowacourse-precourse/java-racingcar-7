package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingCarTest {

    @DisplayName("이름으로 자동차를 생성할 수 있다.")
    @Test
    void createCarByName() {
        // given
        String name = "car1";

        // when
        RacingCar racingCar = new RacingCar(name);

        // then
        assertThat(racingCar)
                .extracting("name", "position")
                .contains(name, 0);
    }

    @DisplayName("4 이상의 값으로 자동차를 움직일 수 있다.")
    @Test
    void attemptMoveWithGraterThanOrEqual4() {
        // given
        RacingCar racingCar = new RacingCar("car1");

        // when
        racingCar.attemptMove(4);

        // then
        assertThat(racingCar).extracting("position").isEqualTo(1);
    }

    @DisplayName("4 미만의 값은 자동차를 움직일 수 없다.")
    @Test
    void attemptMoveWithLessThan4() {
        // given
        RacingCar racingCar = new RacingCar("car1");

        // when
        racingCar.attemptMove(3);

        // then
        assertThat(racingCar).extracting("position").isEqualTo(0);
    }

    @DisplayName("특정 위치에 자동차가 있는지 확인할 수 있다.")
    @Test
    void isSamePosition() {
        // given
        int position = 3;
        RacingCar racingCar = new RacingCar("car1", position);

        // when
        boolean result = racingCar.isSamePosition(position);

        // then
        assertThat(result).isTrue();
    }

}
