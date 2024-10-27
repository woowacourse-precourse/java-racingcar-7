package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

class CarsTest {

    @Test
    @DisplayName("자동차 이름 목록으로 Car 객체 리스트를 생성한다.")
    void 자동차_리스트_생성() {
        // Given
        String carNames = "pobi,woni,jun";

        // When
        Cars cars = new Cars(carNames);
        List<Car> carList = cars.get();

        // Then
        assertThat(carList)
                .extracting(Car::getName)
                .containsExactly("pobi", "woni", "jun");
    }

    @ParameterizedTest
    @NullSource
    @EmptySource
    @ValueSource(strings = {"   "})
    @DisplayName("자동차 이름 목록이 null, 빈 값, 공백일 경우 예외를 발생시킨다.")
    void 자동차_이름_목록_유효성_검사_예외(String carNamesInput) {
        assertThatThrownBy(() -> new Cars(carNamesInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름 목록이 비어 있지 않아야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi,woni,pobi", "pobi,woni,woni"})
    @DisplayName("중복된 자동차 이름이 있을 경우 예외를 발생시킨다.")
    void 중복된_자동차_이름_예외(String carNamesInput) {
        assertThatThrownBy(() -> new Cars(carNamesInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 중복될 수 없습니다.");
    }

    @ParameterizedTest
    @CsvSource({
            "true, 1",
            "false, 0"
    })
    @DisplayName("모든 자동차를 이동 조건에 따라 이동시키거나 멈추게 한다.")
    void 모든_자동차_이동(boolean canMove, int expectedPosition) {
        // Given
        Cars cars = new Cars("car1,car2,car3");

        // When
        cars.attemptCarMovements(() -> canMove);

        // Then
        cars.get().forEach(car -> assertThat(car.getPosition()).isEqualTo(expectedPosition));
    }

    @Test
    @DisplayName("우승자의 이름을 반환한다.")
    void 우승자_찾기() {
        // Given
        Cars cars = new Cars("car1,car2,car3");

        // When
        cars.attemptCarMovements(() -> false); // 모든 자동차 멈춤
        cars.get().get(1).move(() -> true); // 두 번째 자동차만 이동

        // Then
        assertThat(cars.getWinners()).containsExactly("car2");
    }

    @Test
    @DisplayName("우승자가 여러 명일 경우 공동 우승자를 반환한다.")
    void 공동_우승자_찾기() {
        // Given
        Cars cars = new Cars("car1,car2,car3");

        // When
        cars.attemptCarMovements(() -> false); // 모든 자동차 멈춤
        cars.get().get(1).move(() -> true); // 두 번째 자동차만 이동
        cars.get().get(2).move(() -> true); // 세 번째 자동차도 이동

        // Then
        assertThat(cars.getWinners()).containsExactly("car2", "car3");
    }
}