package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

    @Test
    @DisplayName("자동차 객체 생성 성공")
    void createCar() {
        Car car = new Car("pobi");
        assertThat(car.getName()).isEqualTo("pobi");
        assertThat(car.getPosition()).isZero();
    }

    @Test
    @DisplayName("이름이 공백인 경우 예외 발생")
    void createCarWithEmptyName() {
        assertThatThrownBy(() -> new Car(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 공백일 수 없습니다.");
    }

    @Test
    @DisplayName("이름이 5자를 초과하는 경우 예외 발생")
    void createCarWithLongName() {
        assertThatThrownBy(() -> new Car("pobiii"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5자 이하여야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    @DisplayName("무작위 값이 4 이상이면 전진")
    void moveForward(int number) {
        Car car = new Car("pobi");
        car.move(number);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    @DisplayName("무작위 값이 4 미만이면 정지")
    void stay(int number) {
        Car car = new Car("pobi");
        car.move(number);
        assertThat(car.getPosition()).isZero();
    }

    @Test
    @DisplayName("자동차 현재 상태 출력")
    void carStatus() {
        Car car = new Car("pobi");
        car.move(4);
        car.move(4);
        assertThat(car.toString()).isEqualTo("pobi : --");
    }
}