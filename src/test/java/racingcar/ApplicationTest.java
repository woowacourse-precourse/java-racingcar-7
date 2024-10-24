package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.Utils.enterCarList;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 기능_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void RacingCar_construct_test() {
        RacingCar car = new RacingCar("test");
        car.rollDice();
        car.rollDice();
        car.rollDice();
        car.rollDice();
        car.rollDice();
        assertThat(car.getCount()).isBetween(0, 5);
    }

    @Test
    void enterCarList_test() {
        String input = "pobi, woni";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThat(enterCarList())
                .contains("pobi")
                .contains("woni");
    }

    @DisplayName("자동차의 이름이 1자에서 5자 사이가 아니면 예외를 발생한다.")
    @Test
    void RacingCar_exception_test() {
        assertThatThrownBy(() -> new RacingCar("invalid_name"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
