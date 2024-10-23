package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
    void inputStringTest() {
        InputString inputString = new InputString("pobi,woni");
        assertSimpleTest(
            () -> assertThat(inputString.getInputString()).isEqualTo("pobi,woni")
        );
    }

    @Test
    void emptyStringTest() {
        assertSimpleTest(
            () -> assertThatThrownBy(
                () -> new InputString("")
            ).isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void nullStringTest() {
        assertSimpleTest(
            () -> assertThatThrownBy(
                () -> new InputString(null)
            ).isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 자동차_생성_확인() {
        InputString inputString = new InputString("pobi,woni");
        CarCollection carCollection1 = inputString.getCarCollection();

        Car pobiCar = new Car("pobi");
        Car woniCar = new Car("woni");
        CarCollection carCollection2 = new CarCollection(List.of(pobiCar, woniCar));
        assertThat(carCollection1.getCarNames()).isEqualTo(carCollection2.getCarNames());
    }

    @Test
    void 자동차_생성_예외_테스트() {
        InputString inputString = new InputString("pobi,woniii");
        assertThatThrownBy(
            () -> inputString.getCarCollection()
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
