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
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("쉼표가 없는 경우 예외가 발생하는지 검사")
    @Test
    void validateSeperatorPresent() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("jenn", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("입력 마지막에 쉼표가 있는 경우 예외가 발생하는지 검사")
    @Test
    void validateLastCharacterIsComma() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("jenn,", "1"))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @DisplayName("중복된 이름이 있는 경우 예외가 발생하는지 검사")
    @Test
    void validateCarNameDuplicate() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("jenn,kelly,jenn", "1"))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @DisplayName("실행 횟수가 숫자가 아닌 경우 예외가 발생하는지 검사")
    @Test
    void validateGameCountIsNumber() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("jenn, jun", "o"))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @DisplayName("실행 횟수가 0보다 작거나 같은 경우 예외가 발생하는지 검사")
    @Test
    void validateGameCountIsOneOrMore() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("jenn, jun", "-1"))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @DisplayName("우승자가 여러 명일 때 쉼표로 구분하여 출력하는지 검사")
    @Test
    void validateWinnersCommaSeperated() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("jenn, kelly, jun", "2");
                    assertThat(output()).contains("jenn : --", "kelly : --", "jun : -", "최종 우승자 : jenn, kelly");
                },
                MOVING_FORWARD, MOVING_FORWARD, STOP, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
