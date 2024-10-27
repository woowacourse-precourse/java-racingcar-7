package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    private static Stream<Arguments> provideCarNamesAndAttemptInput() {
        return Stream.of(
                Arguments.of(" ", "1"),
                Arguments.of("", "1"),
                Arguments.of("pobi,woni", " "),
                Arguments.of("pobi,woni", "\n")
        );
    }

    @DisplayName("입력 값이 빈 문자열인 경우 예외가 발생한다.")
    @ParameterizedTest
    @MethodSource("provideCarNamesAndAttemptInput")
    void exception1(String carNames, String attempt) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(carNames, attempt))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("자동차 이름 관련 예외")
    @Nested
    class testCarName {
        @DisplayName("자동차 이름이 공백 혹은 빈 문자열일 경우 예외가 발생한다.")
        @Test
        void exception1() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException(",", "3"))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @DisplayName("이름이 중복될 경우 예외가 발생한다.")
        @Test
        void exception2() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("pobi,pobi", "3"))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @DisplayName("자동차 이름에 공백이 포함될 경우 예외가 발생한다.")
        @Test
        void exception3() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("wo n,pobi", "3"))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @DisplayName("자동차 이름 앞뒤에 공백이 있을 경우 예외가 발생한다.")
        @Test
        void exception4() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("woni, po ", "3"))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }
    }

    @DisplayName("자동차 이름 길이 관련 예외")
    @Nested
    class testCarNameLength {
        @DisplayName("이름이 5자를 넘길 경우 예외가 발생한다.")
        @Test
        void exception1() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("pobi,javaji", "3"))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @DisplayName("이름이 5자일 경우 정상 작동한다.")
        @Test
        void test1() {
            assertRandomNumberInRangeTest(
                    () -> {
                        run("pobie,javaj", "1");
                        assertThat(output()).contains("pobie : -", "javaj : ", "최종 우승자 : pobie");
                    },
                    MOVING_FORWARD, STOP
            );
        }

        @DisplayName("이름이 1자일 경우 정상 작동한다.")
        @Test
        void test2() {
            assertRandomNumberInRangeTest(
                    () -> {
                        run("p,j", "1");
                        assertThat(output()).contains("p : -", "j : ", "최종 우승자 : p");
                    },
                    MOVING_FORWARD, STOP
            );
        }
    }

    @DisplayName("시도 횟수 관련 예외")
    @Nested
    class testTryNum {
        @DisplayName("시도 횟수가 음수일 경우 예외가 발생한다.")
        @Test
        void exception1() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("pobi,woni", "-2"))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @DisplayName("시도 횟수가 숫자가 아닐 경우 예외가 발생한다.")
        @Test
        void exception2() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("pobi,woni", "w"))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @DisplayName("시도 횟수에 공백이 포함될 경우 예외가 발생한다.")
        @Test
        void exception3() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("pobi,woni", " 5"))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @DisplayName("시도 횟수가 0일 경우 정상 작동한다.")
        @Test
        void test3() {
            assertSimpleTest(
                    () -> {
                        run("pobi,john", "0");
                        assertThat(output()).contains("");
                    }
            );
        }
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
