package racingcar.car;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.ErrorMessage;

class CarsTest {

    private Car pobi;
    private Car dk;
    private Car foo;
    private MovingStrategy defaultStrategy;

    @BeforeEach
    void setup() {
        defaultStrategy = new RandomMovingStrategy();
        pobi = new Car("pobi", defaultStrategy);
        dk = new Car("DK", defaultStrategy);
        foo = new Car("foo", defaultStrategy);
    }

    @Test
    @DisplayName("Cars 컬렉션이 불변임을 확인한다.")
    void carsAreUnmodifiable() {
        // 수정 가능
        List<Car> modifiableCarList = new ArrayList<>(List.of(pobi));
        modifiableCarList.add(dk);  // 예외가 발생하지 않음

        // 수정 불가능 (불변)
        Cars cars = new Cars(modifiableCarList);
        List<Car> unmodifiableCarList = cars.carList();

        assertThatThrownBy(() -> unmodifiableCarList.add(foo))
                .isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    @DisplayName("Cars 컬렉션에는 같은 이름을 가진 Car 가 존재 할 수 없다.")
    void carsCollectionIsUnique() {
        List<Car> carList = List.of(pobi, pobi);
        assertThatThrownBy(() -> new Cars(carList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.DUPLICATE_CAR_NAME.getMessage());
    }
}