package racingcar.model.car;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("자동차 집합 테스트")
class CarsTest {

    @Test
    @DisplayName("자동차 집합에 자동차를 추가한다")
    void 성공_자동차추가() {
        // Given
        Cars cars = new Cars(Collections.emptyList());
        Car car = new Car("mint", () -> true);

        // When
        cars.add(car);

        // Then
        assertThat(cars).extracting("cars")
                .isEqualTo(List.of(car));
    }

    @Test
    @DisplayName("자동차 집합의 이동여부를 얻는다")
    void 성공_이동여부조회() {
        // Given
        Cars cars = new Cars(List.of(new Car("mint", () -> true)));

        // When
        List<Boolean> moves = cars.doMove();

        // Then
        assertThat(moves).isEqualTo(List.of(true));
    }

    @Test
    @DisplayName("자동차 집합의 이름 집합을 얻는다")
    void 성공_이름집합조회() {
        // Given
        Cars cars = new Cars(List.of(new Car("mint", () -> true), new Car("dobby", () -> true)));

        // When
        List<Name> names = cars.names();

        // Then
        assertThat(names).isEqualTo(List.of(new Name("mint"), new Name("dobby")));
    }

    @Test
    @DisplayName("자동차 집합의 크기를 얻는다")
    void 성공_집합크기조회() {
        // Given
        Cars cars = new Cars(List.of(new Car("mint", () -> true)));

        // When
        int size = cars.size();

        // Then
        assertThat(size).isEqualTo(1);
    }

    @Test
    @DisplayName("인덱스에 위치한 자동차를 조회한다")
    void 성공_자동차조회() {
        // Given
        Car car = new Car("mint", () -> true);
        Cars cars = new Cars(List.of(car));

        // When
        Car selectedCar = cars.at(0);

        // Then
        assertThat(selectedCar).isEqualTo(car);
    }
}
