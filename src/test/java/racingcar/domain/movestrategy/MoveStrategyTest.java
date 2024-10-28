package racingcar.domain.movestrategy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Car;
import racingcar.domain.CarName;
import racingcar.domain.CarPosition;
import racingcar.domain.Cars;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MoveStrategyTest {

    @DisplayName("숫자의 값이 4이상이면 전진할 수 있다.")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void canMoveIfNumberIsMoreThanThree(int number) {
        //given
        List<Car> initialCars = List.of(
                new Car(new CarName("a"), new CarPosition()),
                new Car(new CarName("b"), new CarPosition()),
                new Car(new CarName("c"), new CarPosition()));
        Cars cars = new Cars(initialCars);
        //when
        cars.move(new FixedMoveStrategy(() -> number));
        // then
        assertThat(cars.getCars().get(0).getPosition().getPosition()).isEqualTo(1);
        assertThat(cars.getCars().get(1).getPosition().getPosition()).isEqualTo(1);
        assertThat(cars.getCars().get(2).getPosition().getPosition()).isEqualTo(1);
    }

    @DisplayName("숫자의 값이 4미만이면 전진할 수 없다.")
    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3})
    void cannotMoveIfNumberIsMoreThanThree(int number) {
        //given
        List<Car> initialCars = List.of(
                new Car(new CarName("a"), new CarPosition()),
                new Car(new CarName("b"), new CarPosition()),
                new Car(new CarName("c"), new CarPosition()));
        Cars cars = new Cars(initialCars);
        //when
        cars.move(new FixedMoveStrategy(() -> number));
        // then
        assertThat(cars.getCars().get(0).getPosition().getPosition()).isEqualTo(0);
        assertThat(cars.getCars().get(1).getPosition().getPosition()).isEqualTo(0);
        assertThat(cars.getCars().get(2).getPosition().getPosition()).isEqualTo(0);
    }

    @DisplayName("입력 값이 0-9범위 밖이면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1,10,100})
    void throwsExceptionWhenNumberIsOutOfRange(int number) {
        //given
        List<Car> initialCars = List.of(
                new Car(new CarName("a"), new CarPosition()),
                new Car(new CarName("b"), new CarPosition()),
                new Car(new CarName("c"), new CarPosition()));
        Cars cars = new Cars(initialCars);
        //when
        // then
        assertThatThrownBy(() ->  cars.move(new FixedMoveStrategy(() -> number)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("0에서 9사이의 값만 입력하실 수 있습니다.");
    }
}