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
    }
}
