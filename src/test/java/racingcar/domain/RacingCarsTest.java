package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

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

    @Test
    @DisplayName("자동차 리스트는 NULL이 될 수 없다.")
    public void cannotCreateRacingCarListWithNull() {
        assertThatThrownBy(() -> new RacingCars(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("중복되지 않은 이름을 가진 자동차는 추가할 수 있다.")
    public void addRacingCarWithNotDuplicatedName() {
        List<RacingCar> createdCars = new ArrayList<>(List.of(
                new RacingCar("이미"),
                new RacingCar("만들어진"),
                new RacingCar("자동차들")
        ));
        RacingCars racingCars = new RacingCars(createdCars);

        RacingCar racingCar = new RacingCar("new");

        assertDoesNotThrow(() -> racingCars.addRacingCar(racingCar));
    }

}
