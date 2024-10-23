package racingcar.domain.race;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;
import racingcar.domain.car.CarName;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacePositionTest {
    @Test
    @DisplayName("중복된 이름의 CarName으로 생성 시 IllegalArgumentExcpetion을 반환하는지 확인")
    void testDuplicateCarNameThrowIllegalArgumentException() {
        CarName sameName = CarName.of("same");
        Car sameNameCar = new Car(sameName);
        Car sameNameAnotherCar = new Car(sameName);
        List<Car> duplcateCarList = List.of(sameNameCar, sameNameAnotherCar);

        assertThatThrownBy(() -> new RacePosition(duplcateCarList)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("CarName에 따른 Car를 반환하는지 확인")
    void testfindCarByCarName() {
        CarName targetName = CarName.of("dummy");
        Car targetCar = new Car(targetName);
        List<Car> cars = List.of(targetCar);
        RacePosition racePosition = new RacePosition(cars);

        Car actual = racePosition.findByCarName(targetName);

        assertThat(actual).isEqualTo(targetCar);
    }
}