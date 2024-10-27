package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.TestConstants.CAR_MOVE_COUNT;
import static racingcar.TestConstants.CAR_MOVE_TWICE;
import static racingcar.TestConstants.CAR_NAME_POBI;
import static racingcar.TestConstants.MAX;
import static racingcar.TestConstants.START_LOCATION;
import static racingcar.common.Constants.MOVE;
import static racingcar.common.Constants.ROUND_RESULT_PROMPT;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {
    @Test
    @DisplayName("자동차 이름을 넣을 경우 새로운 자동차가 생성된다.")
    void createNewCar () {
        // given
        String carName = CAR_NAME_POBI;

        // when
        Car car = new Car(carName);

        // then
        assertThat(car.compareCarName(carName)).isTrue();
        assertThat(car.compareCarGoCnt(START_LOCATION)).isTrue();
    }

    @Test
    @DisplayName("차가 잘 움직인다.")
    void moveCar () {
        // given
        Car car = new Car(CAR_NAME_POBI);

        // when
        car.move();

        // then
        assertThat(car.compareCarGoCnt(CAR_MOVE_COUNT)).isTrue();
    }

    @Test
    @DisplayName("라운드 결과 출력을 위한 값이 반환된다.")
    void getRoundResult () {
        // given
        Car car = new Car(CAR_NAME_POBI);
        car.move();
        car.move();

        // when
        String roundResult = car.getRoundResult();

        // then
        String expectedResult = CAR_NAME_POBI + ROUND_RESULT_PROMPT + MOVE.repeat(CAR_MOVE_TWICE);
        assertThat(roundResult).isEqualTo(expectedResult);
    }
}