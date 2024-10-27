package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.TestConstants.CAR_MOVE_COUNT;
import static racingcar.TestConstants.CAR_NAME_POBI;
import static racingcar.TestConstants.CAR_NAME_WONI;
import static racingcar.TestConstants.MOVE_NUMBER;
import static racingcar.TestConstants.POBI_CAR_INDEX;
import static racingcar.TestConstants.START_LOCATION;
import static racingcar.TestConstants.STOP_NUMBER;
import static racingcar.TestConstants.WONI_CAR_INDEX;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Cars;
import racingcar.domain.RandomNumber;

class CarServiceTest {
    private CarService carService;

    @BeforeEach
    void setUp() {
        carService = new CarService();
    }

    @Test
    @DisplayName("램덤 숫자가 4 이상의 수가 나올 경우 차가 움직인다.")
    void carMove () {
        // given
        RandomNumber randomNumber = new RandomNumber(MOVE_NUMBER);

        List<String> carNames = List.of(CAR_NAME_POBI, CAR_NAME_WONI);
        Cars cars = new Cars(carNames);

        // when
        carService.movePerCar(cars, randomNumber, POBI_CAR_INDEX);

        // then
        assertThat(cars.checkCarMove(POBI_CAR_INDEX, CAR_MOVE_COUNT)).isTrue();
    }

    @Test
    @DisplayName("램덤 숫자가 3 이하의 수가 나올 경우 차가 움직이지 않는다.")
    void carStop () {
        // given
        RandomNumber randomNumber = new RandomNumber(STOP_NUMBER);

        List<String> carNames = List.of(CAR_NAME_POBI, CAR_NAME_WONI);
        Cars cars = new Cars(carNames);

        // when
        carService.movePerCar(cars, randomNumber, WONI_CAR_INDEX);

        // then
        assertThat(cars.checkCarMove(WONI_CAR_INDEX, START_LOCATION)).isTrue();
    }
}