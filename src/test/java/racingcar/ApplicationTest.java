package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
    @DisplayName("이스케이프 문자 처리")
    void nameWithEscapeCharacter() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("po\\bi,wo\"ni", "1");
                    assertThat(output()).contains("po\\bi : -", "wo\"ni : ", "최종 우승자 : po\\bi");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    @DisplayName("이름 앞뒤에 공백이 있을 경우 처리")
    void nameWithBlank() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("po bi, woni", "1");
                    assertThat(output()).contains("po bi : -", "woni : ", "최종 우승자 : po bi");
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
    @DisplayName("이름 문자열이 비었을때 예외 발생")
    void emptyNameString() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("\n", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("빈 이름이 입력되면 예외 발생")
    void nameStringWithEmptyName() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,,woni", "3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("중복된 이름이 입력되면 예외 발생")
    void nameStringWithDuplicateName() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,pobi", "3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("11명이상이 입력되면 예외 발생")
    void nameStringLongerThenTen() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("a,b,c,d,e,f,g,h,i,j,k", "3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("이름이 6자 이상이 입력되면 예외 발생")
    void nameLongerThenSix() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("sixman,woni", "3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("횟수 문자열이 비었을때 예외 발생")
    void emptyNumberString() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "\n"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Test
    @DisplayName("횟수 문자열에 숫자가 아닌게 입력되면 예외 발생")
    void numberStringWithOutNumber() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "a"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("횟수 문자열에 양의 정수가 아닌게 입력되면 예외 발생")
    void numberStringWithOutPositiveInteger() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "-1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("횟수 문자열에 11이상이 입력되면 예외 발생")
    void numberStringWithBiggetThenTen() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "11"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
