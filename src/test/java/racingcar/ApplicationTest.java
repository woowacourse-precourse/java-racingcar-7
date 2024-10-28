package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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

    @ParameterizedTest
    @CsvSource(value = {
            "pobi,javaji / 1",
            "A ,B,C / 2",
            "112,112,BBC / 3",
            "^^*,1a,2b,3c / 4",
            ",a,b, / 5",
            "한글이름,AA,BB,CC / 6",
            "name1,name2,name3 / a",
            "name1,name2,name2 / "
    }, delimiter = '/')
    void 예외_테스트(String carNames, String trialCount) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(carNames, trialCount))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
