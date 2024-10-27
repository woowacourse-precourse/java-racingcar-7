package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
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

        assertEquals(expectedCarList, RacingCar.carList);
    }

    @Test
    void 기능_테스트() {
        assertRandomNumberInRangeTest(
            () -> {
                RacingCar.run("pobi,woni", "1");
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
            },
            MOVING_FORWARD, STOP
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
