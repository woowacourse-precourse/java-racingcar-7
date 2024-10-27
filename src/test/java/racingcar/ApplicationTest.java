package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.HashMap;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @BeforeEach
    void setUp() {
        RacingCar.carList.clear();
    }

    @Test
    void 유효한_입력을_받았을_때_carList_입력_확인() {
        // given
        String carNames = "car1,car2,car3";
        String rounds = "5";

        // when
        RacingCar.run(carNames, rounds);

        // then
        HashMap<String, Integer> expectedCarList = new HashMap<>();
        expectedCarList.put("car1", 0);
        expectedCarList.put("car2", 0);
        expectedCarList.put("car3", 0);

        assertEquals(expectedCarList.keySet(), RacingCar.carList.keySet());
    }

    @Test
    void 자동차_이름의_길이가_5이상이면_예외를_발생시킨다(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
