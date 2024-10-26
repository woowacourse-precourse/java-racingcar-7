package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

@DisplayName("Car클래스 기능 테스트")
public class CarTest {

    @Nested
    @DisplayName("자동차 생성 테스트")
    class CreateCarTest {

        @Test
        @DisplayName("자동차는 입력된 이름으로 생성된다.")
        void carShouldBeCreatedWithGivenName() {
            Car car = new Car("pobi");
            assertThat(car.getName()).isEqualTo("pobi");
        }

        @Test
        @DisplayName("자동차 이름이 5자를 초과하는 경우 예외가 발생한다.")
        void createCarWithNameExceedingLengthShouldThrowException() {
            assertThatThrownBy(() -> new Car("abcdef"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("자동차 이름은 1자 이상 5자 이하만 가능합니다.");
        }

        @Test
        @DisplayName("자동차 이름이 빈 문자열인 경우 예외가 발생한다.")
        void createCarWithEmptyNameShouldThrowException() {
            assertThatThrownBy(() -> new Car(""))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("자동차 이름은 1자 이상 5자 이하만 가능합니다.");
        }
    }

    @Nested
    @DisplayName("자동차 이동 테스트")
    class MoveCarTest {

        @Test
        @DisplayName("MoveStrategy가 참일 때 자동차는 전진한다.")
        void moveWhenMoveStrategyReturnsTrue() {
            Car car = new Car("pobi");
            car.move(() -> true);
            assertThat(car.getPosition()).isEqualTo(1);
        }

        @Test
        @DisplayName("MoveStrategy가 거짓일 때 자동차는 정지한다.")
        void stopWhenMoveStrategyReturnsFalse() {
            Car car = new Car("pobi");
            car.move(() -> false);
            assertThat(car.getPosition()).isEqualTo(0);
        }
    }
}
