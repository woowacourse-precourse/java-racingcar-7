package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CarsTest {
    @Test
    @DisplayName("이름이 5자 이하 일 경우 자동차 생성 성공")
    void carCreationValidName() {
        assertDoesNotThrow(() -> new Car("minsu"));
    }

    @Test
    @DisplayName("자동차 이름을 5자를 초과하면 예외가 발생한다")
    void validateNameLength() {
        assertThrows(IllegalArgumentException.class, () -> new Car("123456"));
    }

    @Test
    @DisplayName("자동차 이름이 빈 값일 경우 예외 발생")
    void carCreationWithEmptyName() {
        assertThrows(IllegalArgumentException.class, () -> new Car(""));
    }

    @Test
    @DisplayName("자동차 이름이 null일 경우 예외 발생")
    void carCreationWithNullName() {
        assertThrows(IllegalArgumentException.class, () -> new Car(null));
    }

    @Test
    @DisplayName("동일한 거리를 이동한 자동차들이 공동 우승한다")
    void multipleWinners() {
        Cars cars = new Cars("car1,car2");
        // 두 자동차를 같은 거리만큼 이동
        cars.moveAll();
        String winners = cars.getWinners();
        assertThat(winners).contains("car1", "car2");
    }
}