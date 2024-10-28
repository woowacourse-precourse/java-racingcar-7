package racingcar.race;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.Application;

class RacingGameTest extends NsTest {

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3", "4", "5"})
    void 시도할_횟수가_1이상_5이하의_숫자형식이면_정상적으로_실행된다(String round) {
        // given

        // when
        // then
        assertRandomNumberInRangeTest(
                () -> {
                    run("whale, mac", round);
                    assertThat(output()).contains("whale :", "mac :", "최종 우승자 :");
                }, 1
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"-", ",", ".", "a", "`"})
    void 시도할_횟수가_숫자가_아니면_예외가_발생한다(String round) {
        // given
        // when
        // then
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("ddd,java", round))
                        .hasCauseInstanceOf(IllegalArgumentException.class)
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "-1", "6", "7"})
    void 시도할_횟수가_0이하_이거나_6이상이면_예외가_발생한다(String invalidRound) {
        // given
        // when
        // then
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("whale,java", invalidRound))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"alone", "one,two,three,four,five,six"})
    void 자동차_이름_입력시_1개이하_또는_6개이상이면_예외가_발생한다(String invalidNameSize) {
        // given
        // when
        // then
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(invalidNameSize, "2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}