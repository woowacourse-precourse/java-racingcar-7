package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.List;

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
    void 유효한_자동차_이름_테스트() {
        List<String> validCarNames = List.of("pobi", "woni", "tom");
        Application.validateCarNames(validCarNames);
    }

    @Test
    void 중복된_자동차_이름_예외_테스트() {
        List<String> duplicateCarNames = List.of("pobi", "pobi", "woni");
        assertThatThrownBy(() -> Application.validateCarNames(duplicateCarNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이름_길이_초과_예외_테스트() {
        List<String> longNameCar = List.of("longname");
        assertThatThrownBy(() -> Application.validateCarNames(longNameCar))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
