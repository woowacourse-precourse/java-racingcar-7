package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.util.FixedMovementStrategy;

class CarsTest {
    private static final int MAX_CAR_COUNT = 10;

    private FixedMovementStrategy fixedMovementStrategy;

    @ParameterizedTest
    @DisplayName("자동차 개수가 10개 이하라면 cars 객체를 생성할 수 있다.")
    @ValueSource(strings = "pobi,woni")
    void canCreateCars(String input) {
        // given
        fixedMovementStrategy = new FixedMovementStrategy(4);
        String[] carNames = input.split(",");

        // when
        Cars cars = new Cars(carNames, fixedMovementStrategy);

        // then
        assertThat(cars.getCars()).hasSize(carNames.length);
    }

    @ParameterizedTest
    @DisplayName("자동차가 10개를 초과라면 cars를 생성할 수 없다.")
    @ValueSource(strings = "car1,car2,car3,car4,car5,car6,car7,car8,car9,car10,car11")
    void throwExceptionWhenCarCountExceedsLimit(String input) {
        // given
        String[] carNames = input.split(",");
        fixedMovementStrategy = new FixedMovementStrategy(4);

        // when & then
        assertThatThrownBy(() -> new Cars(carNames, fixedMovementStrategy))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 수는 " + MAX_CAR_COUNT + " 이하이어야 합니다.");
    }

    @ParameterizedTest
    @DisplayName("움직임 전략이 기준점 이하라면 자동차는 움직인다.")
    @ValueSource(strings = "pobi,woni")
    void moveCarWhenNumberUnderThreshold(String input) {
        // given
        String[] carNames = input.split(",");
        fixedMovementStrategy = new FixedMovementStrategy(4);
        Cars cars = new Cars(carNames, fixedMovementStrategy);

        // when
        cars.moveCars();
        Car pobi = cars.getCars().get(0);
        Car woni = cars.getCars().get(1);

        // then
        assertThat(pobi.getMoveDistance()).isEqualTo(1);
        assertThat(woni.getMoveDistance()).isEqualTo(1);
    }

    @ParameterizedTest
    @DisplayName("움직임 전략이 기준점 이상이라면 자동차는 움직이지 못한다.")
    @ValueSource(strings = "pobi,woni")
    void doNotMoveCarWhenNumberExceedThreshold(String input) {
        // given
        String[] carNames = input.split(",");
        fixedMovementStrategy = new FixedMovementStrategy(3);
        Cars cars = new Cars(carNames, fixedMovementStrategy);

        // when
        cars.moveCars();
        Car pobi = cars.getCars().get(0);
        Car woni = cars.getCars().get(1);

        // then
        assertThat(pobi.getMoveDistance()).isEqualTo(0);
        assertThat(woni.getMoveDistance()).isEqualTo(0);
    }
}