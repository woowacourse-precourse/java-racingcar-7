package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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
    void 정상_테스트1() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,wo ni", "1");
                    assertThat(output()).contains("pobi : -", "wo ni : ", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP
        );
    }
    @Test
    void 정상_테스트2() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "2");
                    assertThat(output()).contains("pobi : -", "woni : -", "pobi : --", "woni : --", "최종 우승자 : pobi, woni");
                },
                4, 4, 5, 6
        );
    }

    @ParameterizedTest
    @CsvSource(value = {
            "pobi,javaj,pobi | 1",
            "pobi,javaji | 1",
            "pobi, | 1",
            "pobi,  ,javaj | 1"},
            delimiter = '|'
    )
    void 이름_형식_예외_테스트(String carNames, String attemptNum) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(carNames, attemptNum))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
