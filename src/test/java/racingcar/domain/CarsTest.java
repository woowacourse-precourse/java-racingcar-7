package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.global.ErrorMessage;

class CarsTest {

    private Car pobi;
    private Car dk;
    private Car foo;

    @BeforeEach
    void setup() {
        MovingStrategy defaultStrategy = () -> true;
        pobi = new Car("pobi", defaultStrategy);
        dk = new Car("DK", defaultStrategy);
        foo = new Car("foo", defaultStrategy);
    }

    @Test
    @DisplayName("Cars 컬렉션이 불변임을 확인한다.")
    void carsAreUnmodifiable() {
        // given
        List<Car> modifiableCarList = new ArrayList<>(List.of(pobi, dk));
        Cars cars = new Cars(modifiableCarList);

        // when
        List<Car> unmodifiableCarList = cars.carList();

        // then
        assertThatThrownBy(() -> unmodifiableCarList.add(foo))
                .isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    @DisplayName("Cars 컬렉션에는 같은 이름을 가진 Car 가 존재할 수 없다.")
    void carsCollectionIsUnique() {
        // given
        List<Car> carListWithDuplicates = List.of(pobi, pobi);

        // when, then
        assertThatThrownBy(() -> new Cars(carListWithDuplicates))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.DUPLICATE_CAR_NAME.getMessage());
    }

    @Test
    @DisplayName("우승자를 올바르게 반환한다.")
    void getWinnerNames() {
        String winner1Name = "win1";
        String winner2Name = "win2";

        Car winner1 = new Car(winner1Name, () -> true);
        Car winner2 = new Car(winner2Name, () -> true);
        Car loser = new Car("loser", () -> false);

        Cars cars = new Cars(List.of(winner1, winner2, loser));
        cars.moveAll();

        List<String> winners = cars.getWinnerNames();

        assertThat(winners).containsExactly(winner1Name, winner2Name);
    }
}
