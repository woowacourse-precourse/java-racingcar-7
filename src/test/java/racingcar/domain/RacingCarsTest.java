package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingCarsTest {

    @Test
    @DisplayName("이름이 중복되는 자동차는 추가할 수 없다.")
    public void CannotAddRacingCarHasDuplicatedName() {
        List<RacingCar> createdCars = List.of(
                new RacingCar("이미"),
                new RacingCar("만들어진"),
                new RacingCar("자동차들")
        );
        RacingCars racingCars = new RacingCars(createdCars);

        RacingCar newRacingCar = new RacingCar("이미");

        assertThatThrownBy(() -> racingCars.addRacingCar(newRacingCar))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
