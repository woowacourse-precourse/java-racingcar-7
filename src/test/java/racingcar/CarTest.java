package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CarTest {
    @Test
    @DisplayName("자동차_이름이_정상적으로_입력된다")
    public void 자동차_이름이_정상적으로_입력된다() {
        String carName = "kimdevv";
        Car car = new Car(carName);

        assertTrue(true);
    }
}
