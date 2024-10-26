package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private final Application application = new Application();

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

    @ParameterizedTest
    @EmptySource
    @ValueSource(strings = {"   "})
    void validateNotEmpty_예외_테스트(String input) {
        assertThatThrownBy(() -> application.validateNotEmpty(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateMinimumTwoCars_예외_테스트() {
        String[] onlyOneCar = {"onlyMe"};
        assertThatThrownBy(() -> application.validateMinimumTwoCars(onlyOneCar))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateUniqueCarName_예외_테스트() {
        String[] carNames = {"twin", "twin"};
        assertThatThrownBy(() -> application.validateUniqueCarName(carNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
