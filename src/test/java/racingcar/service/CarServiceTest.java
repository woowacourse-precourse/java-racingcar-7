package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static racingcar.TestConstants.CAR_MOVE_COUNT;
import static racingcar.TestConstants.CAR_NAME_JUN;
import static racingcar.TestConstants.CAR_NAME_POBI;
import static racingcar.TestConstants.CAR_NAME_WONI;
import static racingcar.TestConstants.MOVED_CAR_INDEX;
import static racingcar.TestConstants.MOVE_NUMBER;
import static racingcar.TestConstants.START_LOCATION;
import static racingcar.TestConstants.STOP_CAR_INDEX;
import static racingcar.TestConstants.STOP_NUMBER;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Cars;
import racingcar.domain.RandomNumber;
import racingcar.domain.RandomNumbers;

class CarServiceTest {
    private CarService carService;

    @BeforeEach
    void setUp() {
        carService = new CarService();
    }

    @Test
    @DisplayName("랜덤한 숫자의 범위에 따라 차가 움직이거나 멈춘다.")
    void playPerGame () {
        // given
        List<RandomNumber> randomNumberList = List.of(
                new RandomNumber(STOP_NUMBER),
                new RandomNumber(MOVE_NUMBER)
        );
        RandomNumbers  randomNumbers = new RandomNumbers(randomNumberList);

        List<String> carNames = List.of(CAR_NAME_POBI, CAR_NAME_WONI);
        Cars cars = new Cars(carNames);

        // when
        carService.playingPerGame(cars, randomNumbers);

        // then
        assertThat(cars.checkCarMove(STOP_CAR_INDEX, START_LOCATION)).isTrue();
        assertThat(cars.checkCarMove(MOVED_CAR_INDEX, CAR_MOVE_COUNT)).isTrue();
    }
}