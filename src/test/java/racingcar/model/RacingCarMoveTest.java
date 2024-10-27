package racingcar.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RacingCarMoveTest {

    @Test
    void 무작위_정수_4이상_일때_자동차_전진_테스트() {
        RacingCarMove car = new RacingCarMove();
        RandomNumber randomNumber = new RandomNumber() {

            @Override
            public int generate() {
                return 4;
            }
        };

        assertEquals(1, car.move(randomNumber));
    }

    @Test
    void 무작위_정수_4미만_일때_자동차_정지_테스트() {
        RacingCarMove car = new RacingCarMove();
        RandomNumber randomNumber = new RandomNumber() {

            @Override
            public int generate() {
                return 3;
            }
        };

        assertEquals(0, car.move(randomNumber));
    }
}
