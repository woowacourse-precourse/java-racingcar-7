package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.ErrorMessage.INVALID_CAR_NAME;
import static racingcar.ErrorMessage.NO_INPUT;
import static racingcar.ErrorMessage.NO_NAME;
import static racingcar.ErrorMessage.TOO_LONG_CAR_NAME;
import static racingcar.ErrorMessage.WRONG_TRY_COUNT;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Nested
    @DisplayName("== 전체 기능 테스트 ==")
    class FeatureTest {
        @Test
        @DisplayName("기본 테스트")
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
        @DisplayName("공동 우승자")
        @CsvSource(value = {"pobi,woni:1:pobi, woni", "a,b,c:1:a, b, c"}, delimiter = ':')
        void 공동_우승자(String names, String tryCnt, String winner) {
            assertRandomNumberInRangeTest(
                    () -> {
                        run(names, tryCnt);
                        assertThat(output()).contains("최종 우승자 : " + winner);
                    },
                    MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
            );
        }
    }

    @Nested
    @DisplayName("== 전체 예외 테스트 ==")
    class ExceptionTest {
        @Test
        @DisplayName("기본 테스트")
        void 예외_테스트() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessage(TOO_LONG_CAR_NAME.getMessage())
            );
        }

        @ParameterizedTest
        @DisplayName("입력이 없음")
        @ValueSource(strings = {"", "pobi", "woni\n"})
        void 입력이_없음(String input) {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException(input))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessage(NO_INPUT.getMessage())
            );
        }

        @ParameterizedTest
        @DisplayName("이름 없음")
        @ValueSource(strings = {",", "woni,,pobi", "포비,우니,,,"})
        void 이름_없음(String names) {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException(names))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessage(NO_NAME.getMessage())
            );
        }

        @ParameterizedTest
        @DisplayName("잘못된 이름 (이름은 영어와 한글로만 이루어져야 한다.)")
        @ValueSource(strings = {"🚗,차차차!", "hi hi, 차 선생", "...,&&,-+", "車,茶,$차", "   "})
        void 잘못된_이름(String names) {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException(names))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessage(INVALID_CAR_NAME.getMessage())
            );
        }

        @ParameterizedTest
        @DisplayName("너무 긴 이름")
        @ValueSource(strings = {"longName", "hi,longName"})
        void 너무_긴_이름(String names) {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException(names))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessage(TOO_LONG_CAR_NAME.getMessage())
            );
        }

        @ParameterizedTest
        @DisplayName("잘못된 횟수")
        @CsvSource(value = {"no,음수:-1", "names:숫자아님"}, delimiter = ':')
        void 잘못된_횟수(String names, String tryCount) {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException(names, tryCount))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessage(WRONG_TRY_COUNT.getMessage())
            );
        }
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
