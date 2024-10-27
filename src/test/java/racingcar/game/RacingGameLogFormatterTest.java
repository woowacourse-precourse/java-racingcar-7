package racingcar.game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Car;

import static org.junit.jupiter.api.Assertions.*;

class RacingGameLogFormatterTest {

    private final RacingGameLogFormatter logFormatter = new RacingGameLogFormatter();

    @Test
    @DisplayName("자동차 로그 포맷팅")
    void test() {
        Car car = new Car("pobi", 4);

        String result = logFormatter.formatCar(car);

        assertEquals("pobi : ----", result);
    }
}