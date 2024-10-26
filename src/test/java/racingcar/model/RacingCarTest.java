package racingcar.model;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RacingCarTest extends NsTest {

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    private static final String NAME = "name";

    @Test
    void 랜덤_값이_4_이상인_경우_전진한다() {
        RacingCar racingCar = new RacingCar(NAME);
        Integer move = racingCar.move(MOVING_FORWARD);
        Assertions.assertEquals(move, 1);
    }

    @Test
    void 랜덤_값이_4_미만인_경우_정지한다() {
        RacingCar racingCar = new RacingCar(NAME);
        Integer move = racingCar.move(STOP);
        Assertions.assertEquals(move, 0);
    }


    @Override
    protected void runMain() {

    }
}
