package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

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
    void 기능_테스트2() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,lee", "3");
                    assertThat(output()).contains(
                            "pobi : -", "woni : -", "lee : ",
                            "pobi : -", "woni : --", "lee : ",
                            "pobi : --", "woni : --", "lee : -",
                            "최종 우승자 : pobi, woni");
                },
                MOVING_FORWARD, MOVING_FORWARD, STOP,
                STOP, MOVING_FORWARD, STOP,
                MOVING_FORWARD, STOP, MOVING_FORWARD
        );
    }

    @Test
    void 이름과_쉼표사이에_공백이_있는_경우() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi    ,   woni", "1");
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
    void 쉼표가_제일_앞_또는_제일_뒤에_위치하는_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(",pobi,javaji,", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("자동차의 이름은 필수입니다.")
        );
    }

    @ValueSource(strings = {"", " "})
    @ParameterizedTest
    void 경주할_자동차가_하나도_없는_경우(String carName) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(carName, "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("자동차의 이름은 필수입니다.")
        );
    }

    @ValueSource(strings = {",", ",,"})
    @ParameterizedTest
    void 쉼표만_존재하는_경우(String carName) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(carName, "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("자동차의 개수는 1 이상 100 이하여야 합니다.")
        );
    }

    @ValueSource(strings = {"pobi,,jun", "pobi,jun,,jae"})
    @ParameterizedTest
    void 쉼표가_이름_중간에_연속해서_위치하는_경우(String carName) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(carName, "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("자동차의 이름은 필수입니다.")
        );
    }

    @Test
    void 중복된_이름의_자동차가_존재하는_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("lee,lee,hun", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("중복된 자동차가 존재합니다.")
        );
    }

    @ParameterizedTest
    @CsvSource({"0", "-1", "101"})
    void 시도_횟수가_0_이하_100_초과인_경우(String round) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("lee,hun", round))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("시도 횟수는 1 이상 100 이하여야 합니다.")
        );
    }

    @ParameterizedTest
    @CsvSource({"dlwogns", "11dl"})
    void 시도_횟수가_숫자가_아닌_경우(String round) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("lee,hun", round))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("숫자를 입력하세요")
        );
    }

    @ValueSource(strings = {"", " "})
    @ParameterizedTest
    void 시도_횟수를_아무것도_작성하지_않은_경우(String round) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("lee,hun", round))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("숫자를 입력하세요")
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
