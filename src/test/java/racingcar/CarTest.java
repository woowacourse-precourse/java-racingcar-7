package racingcar;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @DisplayName("Car의 위치를 반환하는지 테스트")
    @Test
    void getPosition() {
        // given
        Engine engine = new RandomEngine();
        Car car = Car.of("pobi", engine);

        // when
        int position = car.getPosition();

        // then
        assertEquals(0, position);
    }
}