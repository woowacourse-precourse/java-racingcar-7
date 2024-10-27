package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.constant.ErrorMessage.EMPTY_NAME;
import static racingcar.constant.ErrorMessage.INVALID_CAR_NAME;
import static racingcar.constant.ErrorMessage.INVALID_RACE_TIME;
import static racingcar.constant.ErrorMessage.NEGATIVE_RACE_TIME;
import static racingcar.constant.ErrorMessage.NO_INPUT;
import static racingcar.constant.ErrorMessage.TOO_LONG_CAR_NAME;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("경주 테스트")
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

        @Test
        @DisplayName("과정 확인")
        void 과정_확인() {
            assertRandomNumberInRangeTest(
                    () -> {
                        run("fox,russ,jokic", "3");
                        assertThat(output()).contains(
                                "fox : -", "russ : ", "jokic : ",
                                "fox : --", "russ : -", "jokic : ",
                                "fox : ---", "russ : --", "jokic : -",
                                "최종 우승자 : fox"
                        );
                    },
                    MOVING_FORWARD, STOP, STOP,
                    MOVING_FORWARD, MOVING_FORWARD, STOP,
                    MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
            );
        }

        @ParameterizedTest
        @DisplayName("공동 우승")
        @CsvSource(value = {"pobi,woni#1#pobi, woni", "a,b,c#1#a, b, c"}, delimiter = '#')
        void 공동_우승(String names, String raceTime, String winners) {
            assertRandomNumberInRangeTest(
                    () -> {
                        run(names, raceTime);
                        assertThat(output()).contains(
                                "최종 우승자 : " + winners); // TODO: RaceOutput에서 "최종 우승자 : " 상수화해서 가져오기
                    },
                    MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
            );
        }

        @ParameterizedTest
        @DisplayName("모두 우승")
        @CsvSource(value = {"every,body#0#every, body", "a,b,c#3#a, b, c"}, delimiter = '#')
        void 모두_우승(String names, String raceTime, String winners) {
            assertRandomNumberInRangeTest(
                    () -> {
                        run(names, raceTime);
                        assertThat(output()).contains("최종 우승자 : " + winners);
                    },
                    MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
            );
        }

        @ParameterizedTest
        @DisplayName("단독 우승")
        @CsvSource(value = {"씨비스킷,제독#1#씨비스킷", "맥퀸,킹,힉스#2#맥퀸"}, delimiter = '#')
        void 단독_우승(String names, String raceTime, String winners) {
            assertRandomNumberInRangeTest(
                    () -> {
                        run(names, raceTime);
                        assertThat(output()).contains("최종 우승자 : " + winners);
                    },
                    MOVING_FORWARD, STOP, STOP, STOP, STOP, STOP
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
        @ValueSource(strings = {"\n", ",", "woni,,pobi", "포비,우니,"})
        void 이름_없음(String names) {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException(names))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessage(EMPTY_NAME.getMessage())
            );
        }

        @ParameterizedTest
        @DisplayName("잘못된 이름 (이름은 영어와 한글로만)")
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
        @DisplayName("횟수가 숫자 아님")
        @CsvSource(value = {"문자#숫자가_아님", "names#?!!"}, delimiter = '#')
        void 횟수가_숫자_아님(String names, String raceTime) {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException(names, raceTime))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessage(INVALID_RACE_TIME.getMessage())
            );
        }

        @ParameterizedTest
        @DisplayName("음수 횟수")
        @CsvSource(value = {"음수#-1", "names#-777"}, delimiter = '#')
        void 음수_횟수(String names, String raceTime) {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException(names, raceTime))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessage(NEGATIVE_RACE_TIME.getMessage())
            );
        }
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
