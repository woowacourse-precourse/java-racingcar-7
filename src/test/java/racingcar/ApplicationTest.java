package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.Application.createCarNames;

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
    void 자동차_이름_분리_테스트() {
        String carName = "pobi,woni";
        List<String> expectedCarNames = Arrays.asList("pobi", "woni");

        assertThat(createCarNames(carName)).isEqualTo(expectedCarNames);
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 자동차_이름_부여_테스트() {
        Application application = new Application();
        List<String> carNames = Arrays.asList("pobi", "woni");
        List<Car> cars = application.createCars(carNames);

        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(cars.get(0).isName("pobi"))
                    .isTrue();
            softly.assertThat(cars.get(1).isName("woni"))
                    .isTrue();
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
