package racingcar.domain.car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

    @DisplayName("자동차의 개수가 0개인 경우 예외가 발생한다.")
    @Test
    void createCarsWhenCarLengthIsZeroThrowsException() {
        //given
        List<String> names = Collections.emptyList();

        //when //then
        assertThatThrownBy(() -> Cars.from(names, () -> true))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차의 개수는 1 이상 100 이하여야 합니다.");
    }

    @DisplayName("자동차의 개수가 100개를 초과한 경우 예외가 발생한다.")
    @Test
    void createCarsWhenCarLengthExceedThrowsException() {
        //given
        List<String> names = IntStream.rangeClosed(1, 101)
                .mapToObj(i -> "n" + i)
                .collect(Collectors.toList());

        //when //then
        assertThatThrownBy(() -> Cars.from(names, () -> true))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차의 개수는 1 이상 100 이하여야 합니다.");
    }

    @DisplayName("중복된 이름의 자동차 이름이 있을 경우 예외가 발생한다.")
    @Test
    void createCarsWhenDuplicatedCarNameThrowsException() {
        //given
        List<String> names = List.of("lee", "jae", "hun", "jae");

        //when //then
        assertThatThrownBy(() -> Cars.from(names, () -> true))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복된 자동차가 존재합니다.");
    }

    @DisplayName("모든 자동차를 이동시킨다.")
    @Test
    void moveAll() {
        //given
        List<Car> cars = List.of(
                new Car(new CarName("lee"), () -> true),
                new Car(new CarName("jae"), () -> false),
                new Car(new CarName("hun"), () -> true));
        Cars carGroups = Cars.from(cars);

        //when
        carGroups.moveAll();

        //then
        assertThat(cars).extracting("status")
                .containsExactly(
                        new CarStatus("lee", 1),
                        new CarStatus("jae", 0),
                        new CarStatus("hun", 1)
                );
    }

    @DisplayName("가장 먼 거리를 간 자동차들을 조회한다.")
    @Test
    void getMaxCars() {
        //given
        List<Car> cars = List.of(
                new Car(new CarName("name1"), () -> true, new Position(1)),
                new Car(new CarName("name2"), () -> true, new Position(5)),
                new Car(new CarName("name3"), () -> true, new Position(2)),
                new Car(new CarName("name4"), () -> true, new Position(4)),
                new Car(new CarName("name5"), () -> true, new Position(5)));
        Cars carGroups = Cars.from(cars);

        //when
        List<Car> maxCars = carGroups.getMaxCars();

        //then
        assertThat(maxCars).extracting("name")
                .containsExactly("name2", "name5");
    }
}