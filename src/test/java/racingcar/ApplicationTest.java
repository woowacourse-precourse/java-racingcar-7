package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SuppressWarnings("NonAsciiCharacters")
class ApplicationTest extends NsTest {

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 같이_경주하고_단일_우승한다() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "1");
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
            },
            MOVING_FORWARD, STOP
        );
    }

    @Test
    void 같이_경주하고_두_명_이상_우승한다() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi, woni");
                },
                MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    void 혼자_경주한다() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi", "1");
                    assertThat(output()).contains("pobi : -", "최종 우승자 : pobi");
                },
                MOVING_FORWARD
        );
    }

    @Nested
    class 예외가_발생한다 {

        @Test
        void 이름이_6글자_이상일_경우_예외가_발생한다() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @ParameterizedTest
        @ValueSource(strings = {"pobi.woni,jun", "poni/woni/jun"})
        void 자동차_입력에_잘못된_구분자가_있을_경우_예외가_발생한다(String carName) {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException(carName, "1"))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @ParameterizedTest
        @ValueSource(strings = {" ", " , , ", ""})
        void 자동차_입력에_공백이_입력된_경우_예외가_발생한다(String carName) {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException(carName, "1"))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @ParameterizedTest
        @ValueSource(strings = {"-5","a"})
        void 횟수_입력이_음수_및_문자인_경우_예외가_발생한다(String chance) {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("pobi,woni", chance))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
