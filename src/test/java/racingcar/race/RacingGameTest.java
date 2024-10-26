package racingcar.race;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.Application;

class RacingGameTest extends NsTest {

    @ParameterizedTest
    @ValueSource(strings = {"1", "3", "11", "20", "100", "9"})
    void 시도할_횟수가_숫자형식이면_정상적으로_실행된다(String tryCount) {
        // given

        // when
        // then
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", tryCount))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"-", ",", "", ".", "a", "`"})
    void 시도할_횟수가_숫자가_아니면_예외가_발생한다(String tryCount) {
        // given

        // when
        // then
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", tryCount))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}