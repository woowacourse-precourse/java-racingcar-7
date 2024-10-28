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
        MovingStrategy defaultStrategy = () -> true; // 항상 이동하는 전략
        pobi = new Car("pobi", defaultStrategy);
        dk = new Car("DK", defaultStrategy);
        foo = new Car("foo", defaultStrategy);
    }

    @Test
    @DisplayName("Cars 컬렉션이 불변임을 확인한다.")
    void carsAreUnmodifiable() {
        List<Car> modifiableCarList = new ArrayList<>(List.of(pobi, dk));
        Cars cars = new Cars(modifiableCarList);

        List<Car> unmodifiableCarList = cars.carList();

        assertThatThrownBy(() -> unmodifiableCarList.add(foo))
                .isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    @DisplayName("Cars 컬렉션에는 같은 이름을 가진 Car가 존재할 수 없다.")
    void carsCollectionIsUnique() {
        List<Car> carListWithDuplicates = List.of(pobi, pobi);

        assertThatThrownBy(() -> new Cars(carListWithDuplicates))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.DUPLICATE_CAR_NAME.getMessage());
    }

    @Test
    @DisplayName("자동차 이름이 쉼표로 구분된 문자열로부터 Cars 객체를 생성할 수 있다.")
    void createCarsFromCommaSeparatedString() {
        String carNames = "pobi,DK,foo";
        MovingStrategy movingStrategy = () -> true;

        Cars cars = Cars.of(carNames, movingStrategy);

        assertThat(cars.carList())
                .hasSize(3)
                .extracting(Car::getName)
                .containsExactly("pobi", "DK", "foo");
    }

    @Test
    @DisplayName("모든 자동차가 이동하는지 확인한다.")
    void allCarsMove() {
        Cars cars = new Cars(List.of(pobi, dk, foo));

        cars.moveAll();

        assertThat(cars.carList())
                .extracting(Car::getPosition)
                .containsExactly(1, 1, 1); // 모든 자동차가 이동했으므로 위치가 1이어야 함
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

        cars.moveAll(); // 모든 차를 이동시킴
        List<String> winners = cars.getWinnerNames();

        assertThat(winners).containsExactlyInAnyOrder(winner1Name, winner2Name);
    }

    @Test
    @DisplayName("Cars 컬렉션이 비어 있을 때 예외가 발생한다.")
    void exceptionWhenNoCarsAvailable() {
        List<Car> emptyCarList = List.of();
        Cars emptyCars = new Cars(emptyCarList);

        assertThatThrownBy(emptyCars::getWinnerNames)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NO_CARS_AVAILABLE.getMessage());
    }

    @Test
    @DisplayName("라운드 점수를 올바르게 생성한다.")
    void createRoundScores() {
        Cars cars = new Cars(List.of(pobi, dk, foo));
        cars.moveAll(); // 모든 차를 이동시킴

        RoundScores roundScores = cars.createRoundScores();

        assertThat(roundScores.carStates())
                .hasSize(3)
                .extracting(CarState::position)
                .containsExactly(1, 1, 1); // 모든 차가 1만큼 이동한 상태여야 함
    }
}
