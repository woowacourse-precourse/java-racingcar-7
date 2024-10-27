package racingcar.domain.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.model.car.Car;
import racingcar.infrastructure.constant.CarConstants;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarRacingManagerTest {
    @Test
    @DisplayName("자동차를 움직일 수 있다.")
    void 자동차_움직이기() {
        // given
        final CarRacingManager carRacingManager = CarRacingManager.from("1,2,3");

        // when
        carRacingManager.moveForward("1");

        // then
        final Car movedCar = carRacingManager.getList().stream()
                .filter(car -> car.getName().equals("1"))
                .findFirst()
                .get();
        assertThat(movedCar.getDistance()).isEqualTo(1);
    }

    @Test
    @DisplayName("우승자를 출력할 수 있다.")
    void 우승자_출력() {
        // given
        final CarRacingManager carRacingManager = CarRacingManager.from("1,2,3");

        // when
        carRacingManager.moveForward("1");

        // then
        assertThat(carRacingManager.getWinners()).isEqualTo("1");
    }

    @Test
    @DisplayName("우승자가 여러 명일 수 있다.")
    void 우승자_여러명() {
        // given
        final CarRacingManager carRacingManager = CarRacingManager.from("우승자1, 우승자2, loser");
        carRacingManager.moveForward("우승자1");
        carRacingManager.moveForward("우승자2");

        // when
        final String winners = carRacingManager.getWinners();

        // then
        assertThat(winners.split(CarConstants.JOIN_DELIMITER)).containsExactly("우승자1", "우승자2");
    }
}