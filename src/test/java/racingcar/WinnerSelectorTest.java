package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class WinnerSelectorTest {

    @DisplayName("우승자가 한 명일 경우 해당 우승자를 반환한다.")
    @Test
    void calculateWinnersWithOneWinner() {

        Car car1 = Car.createCar("apple");
        Car car2 = Car.createCar("lemon");
        Car car3 = Car.createCar("grape");
        int randomNumber = 4;
        car1.proceed(randomNumber);
        List<Car> cars = List.of(car1, car2, car3);

        List<String> winners = WinnerSelector.calculateWinners(cars);

        Assertions.assertThat(winners).hasSize(1)
            .containsExactlyInAnyOrder("apple");
    }

    @DisplayName("우승자가 두 명 이상일 경우 우승자를 모두 반환한다.")
    @Test
    void calculateWinnersWithTwoWinners() {

        Car car1 = Car.createCar("apple");
        Car car2 = Car.createCar("lemon");
        Car car3 = Car.createCar("grape");
        int randomNumber = 4;
        car1.proceed(randomNumber);
        car2.proceed(randomNumber);
        List<Car> cars = List.of(car1, car2, car3);

        List<String> winners = WinnerSelector.calculateWinners(cars);

        Assertions.assertThat(winners).hasSize(2)
            .containsExactlyInAnyOrder("apple", "lemon");
    }

}