package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.message.ErrorMessages.DUPLICATED_NAMES;
import static racingcar.message.ErrorMessages.UNPROVIDED_NAMES;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.InvalidInputException;

class CarsTest {

    @Test
    @DisplayName("자동차가 정상적으로 생성되는지 테스트")
    void testCarsCreation() {
        // given
        String inputCarNames = "pobi,woni,honux";

        // when
        Cars cars = new Cars(inputCarNames);

        // then
        List<Car> carList = cars.getCars();
        assertThat(carList).hasSize(3);  // 3개의 자동차가 생성되어야 함
        assertThat(carList).extracting(Car::getName).containsExactly("pobi", "woni", "honux");
    }

    @Test
    @DisplayName("자동차가 정상적으로 경주하는지 테스트")
    void testCarsRace() {
        // given
        String inputCarNames = "pobi,woni,honux";
        Cars cars = new Cars(inputCarNames);
        List<Car> initialPositions = cars.getCars();

        // when
        cars.race();

        // then
        List<Car> finalPositions = cars.getCars();
        for (int i = 0; i < initialPositions.size(); i++) {
            assertThat(finalPositions.get(i).getPosition()).isGreaterThanOrEqualTo(
                    initialPositions.get(i).getPosition());
        }
    }

    @Test
    @DisplayName("우승자를 정상적으로 반환하는지 테스트")
    void testGetWinners() {
        // given
        Car car1 = new Car("pobi");
        Car car2 = new Car("woni");
        Car car3 = new Car("honux");

        car1.move(5);
        car2.move(3);
        car3.move(5);

        List<Car> cars = Arrays.asList(car1, car2, car3);

        // when
        Winners winners = new Winners(cars);

        // then
        assertThat(winners.getNames()).containsExactlyInAnyOrder("pobi", "honux");
    }

    @Test
    @DisplayName("자동차 이름이 중복되었을 때 예외 발생 테스트")
    void testDuplicatedCarNamesThrowsException() {
        // given
        String inputCarNames = "pobi,woni,pobi";

        // when & then
        assertThatThrownBy(() -> new Cars(inputCarNames))
                .isInstanceOf(InvalidInputException.class)
                .hasMessageContaining(DUPLICATED_NAMES);
    }

    @Test
    @DisplayName("자동차 이름이 제공되지 않았을 때 예외 발생 테스트")
    void testNoCarNamesThrowsException() {
        // given
        String inputCarNames = " ";

        // when & then
        assertThatThrownBy(() -> new Cars(inputCarNames))
                .isInstanceOf(InvalidInputException.class)
                .hasMessageContaining(UNPROVIDED_NAMES);
    }
}
