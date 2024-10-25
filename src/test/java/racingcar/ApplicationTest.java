package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
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
    void 이름_5글자_초과_예외_테스트() {
        validNameException("messi,ronaldo");
    }

    @Test
    void 다른구분자_예외_테스트() {
        validNameException("messi%silva");
    }

    @Test
    void 쉼표중복_예외_테스트() {
        validNameException("messi,,silva");
    }

    @Test
    void 쉼표앞뒤_예외_테스트() {
        validNameException(",messi,silva,");
    }

    @Test
    void 동일이름_예외_테스트() {
        validNameException("messi,messi");
    }

    @Test
    void 이름_띄어쓰기_예외_테스트() {
        validNameException("me ssi,sonny");
    }

    @Test
    void 이름_특수문자_예외_테스트() {
        validNameException("mess$,sonny");
    }

    @Test
    void 빈값_예외_테스트() {
        validNameException("");
    }

    @Test
    void 공백_예외_테스트() {
        validNameException("  ");
    }

    @Test
    void 시도횟수_문자_예외_테스트() {
        validAttemptException("a");
        validAttemptException("abc%");
    }

    @Test
    void 시도횟수_소수_예외_테스트() {
        validAttemptException("1.5");
    }

    @Test
    void 시도횟수_음수_예외_테스트() {
        validAttemptException("-10");
    }

    private void validNameException(String input) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(input, "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    private void validAttemptException(String number) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", number))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
