package racingcar.model.car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.exception.InvalidNameException;

@DisplayName("자동차 집합 테스트")
class CarsTest {
    @Nested
    @DisplayName("생성 테스트")
    class 생성_테스트 {
        @Test
        @DisplayName("자동차 집합을 생성한다")
        void 성공_생성() {
            // Given
            List<Car> cars = List.of(new Car("mint", () -> true), new Car("dobby", () -> true));

            // When & Then
            assertThatCode(() -> new Cars(cars))
                    .doesNotThrowAnyException();
        }

        @Test
        @DisplayName("자동차 집합에서 이름이 중복되면 예외가 발생한다")
        void 실패_생성_이름중복() {
            // Given
            List<Car> duplicatedNamesCars = List.of(new Car("mint", () -> true), new Car("mint", () -> true));

            // When & Then
            assertThatThrownBy(() -> new Cars(duplicatedNamesCars))
                    .isExactlyInstanceOf(InvalidNameException.class)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("이름은 중복될 수 없습니다.");
        }
    }

    @Nested
    @DisplayName("추가 테스트")
    class 추가_테스트 {
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
        @DisplayName("자동차를 추가할 때 이름이 중복되면 예외가 발생한다")
        void 실패_자동차추가_이름중복() {
            // Given
            Cars cars = new Cars(List.of(new Car("mint", () -> true)));

            // When & Then
            assertThatThrownBy(() -> cars.add(new Car("mint", () -> true)))
                    .isExactlyInstanceOf(InvalidNameException.class)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("이름은 중복될 수 없습니다.");
        }
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
