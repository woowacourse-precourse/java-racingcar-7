package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingGameTest {

    @Test
    @DisplayName("한명이 우승하는 경우 테스트")
    void successfullyFindWinnerWhenSongIsWinner() {
        //given
        Car car1 = settingMoveCar("song", 4);
        Car car2 = settingMoveCar("lee", 3);
        Car car3 = settingMoveCar("park", 2);
        Car car4 = settingMoveCar("kim", 1);
        List<Car> cars = List.of(car1, car2, car3, car4);
        RacingGame carContainer = new RacingGame(cars);

        String expected = "song";

        //when
        String actual = carContainer.findWinnerCarNames();

        //then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("두명이 우승하는 경우 테스트")
    void successfullyFindWinnerWhenSongAndParkIsWinner() {
        //given
        Car car1 = settingMoveCar("song", 4);
        Car car2 = settingMoveCar("lee", 3);
        Car car3 = settingMoveCar("park", 4);
        Car car4 = settingMoveCar("kim", 1);
        List<Car> cars = List.of(car1, car2, car3, car4);
        RacingGame carContainer = new RacingGame(cars);

        String expected = "song, park";

        //when
        String actual = carContainer.findWinnerCarNames();

        //then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("세명이 우승하는 경우 테스트")
    void successfullyFindWinnerWhenSongAndParkAndKimIsWinner() {
        //given
        Car car1 = settingMoveCar("song", 4);
        Car car2 = settingMoveCar("lee", 3);
        Car car3 = settingMoveCar("park", 4);
        Car car4 = settingMoveCar("kim", 4);
        List<Car> cars = List.of(car1, car2, car3, car4);
        RacingGame carContainer = new RacingGame(cars);

        String expected = "song, park, kim";

        //when
        String actual = carContainer.findWinnerCarNames();

        //then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("네명이 우승하는 경우 테스트")
    void successfullyFindWinnerWhenEveryoneIsWinner() {
        //given
        Car car1 = settingMoveCar("song", 4);
        Car car2 = settingMoveCar("lee", 4);
        Car car3 = settingMoveCar("park", 4);
        Car car4 = settingMoveCar("kim", 4);
        List<Car> cars = List.of(car1, car2, car3, car4);
        RacingGame carContainer = new RacingGame(cars);

        String expected = "song, lee, park, kim";

        //when
        String actual = carContainer.findWinnerCarNames();

        //then
        assertThat(actual).isEqualTo(expected);
    }

    private Car settingMoveCar(String name, int moveCount) {
        Car car = new Car(name);
        for (int i = 0; i < moveCount; i++) {
            car.moveForward(() -> 9);
        }
        return car;
    }
}
