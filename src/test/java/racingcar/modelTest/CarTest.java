package racingcar.modelTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.model.Car;

import static org.assertj.core.api.Assertions.*;

class CarTest {

    @Test
    @DisplayName("자동차 생성 성공")
    void createCar() {
        assertThatNoException()
                .isThrownBy(() -> new Car("pobi"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "   "})
    @DisplayName("자동차 이름이 빈 문자열인 경우")
    void createCarWithEmptyName(String name) {
        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 공백이거나 빈 문자열일 수 없습니다");
    }

    @Test
    @DisplayName("자동차 이름이 5자 초과인 경우")
    void createCarWithLongName() {
        assertThatThrownBy(() -> new Car("carname"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 5자를 초과할 수 없습니다");
    }

    @Test
    @DisplayName("전진 조건을 만족하는 경우")
    void moveForward() {
        Car car = new Car("pobi");
        car.move(4);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("전진 조건을 만족하지 않는 경우")
    void notMoveForward() {
        Car car = new Car("pobi");
        car.move(3);
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("toString 메서드 검증")
    void carToString() {
        Car car = new Car("pobi");
        car.move(4);
        assertThat(car.toString()).isEqualTo("pobi : -");
    }

    @Test
    @DisplayName("null 이름으로 생성 시도")
    void createCarWithNullName() {
        assertThatThrownBy(() -> new Car(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 공백이거나 빈 문자열일 수 없습니다");
    }

    @Test
    @DisplayName("자동차 이름 반환")
    void getCarName() {
        Car car = new Car("pobi");
        assertThat(car.getName()).isEqualTo("pobi");
    }
}