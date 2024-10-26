package racingcar;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    @DisplayName("자동차 이름을 저장한다")
    void carStoresName() {
        // Given
        Car car = new Car("pobi");

        // When
        String name = car.getName();

        // Then
        assertThat(name).isEqualTo("pobi");
    }

    @Test
    @DisplayName("전진이 허용되면 한 칸 전진한다")
    void carMovesForward() {
        // Given
        Car car = new Car("pobi");

        // When
        car.move();

        // Then
        assertThat(car.getDistance()).isEqualTo(1);
    }
}
