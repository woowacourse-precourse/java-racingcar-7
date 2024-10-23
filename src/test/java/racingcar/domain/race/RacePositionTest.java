package racingcar.domain.race;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.domain.car.Car;
import racingcar.domain.car.CarName;
import racingcar.domain.car.CarPosition;

import java.util.List;
import java.util.stream.Stream;

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
    void testFindCarByCarName() {
        CarName targetName = CarName.of("dummy");
        Car targetCar = new Car(targetName);
        List<Car> cars = List.of(targetCar);
        RacePosition racePosition = new RacePosition(cars);

        Car actual = racePosition.findByCarName(targetName);

        assertThat(actual).isEqualTo(targetCar);
    }

    @ParameterizedTest
    @DisplayName("Position의 값이 가장 큰 Car의 List를 반환하는지 확인")
    @MethodSource("generateRacePosition")
    void testFindFarthestCar(List<Car> cars, List<Car> farthestCars) {
        RacePosition racePosition = new RacePosition(cars);
        List<Car> actual = racePosition.findFarthestCar();

        assertThat(actual).isEqualTo(farthestCars);
    }

    private static Stream<Arguments> generateRacePosition() {
        return Stream.of(
                Arguments.of(
                        List.of(generateCar("a", 1), generateCar("b", 2)),
                        List.of(generateCar("b", 2))
                        ),
                Arguments.of(
                        List.of(generateCar("a", 1), generateCar("b", 1)),
                        List.of(generateCar("a", 1), generateCar("b", 1))
                )
        );
    }

    private static Car generateCar(String carName, int position) {
        return new Car(CarName.of(carName), CarPosition.of(position));
    }
}