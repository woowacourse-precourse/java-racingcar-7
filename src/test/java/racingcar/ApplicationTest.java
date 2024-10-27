package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

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

    @Test
    void 단일_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("AB", "3");
                    assertThat(output()).contains("AB : -", "최종 우승자 : AB");


                },
                MOVING_FORWARD, STOP
        );
    }

    // 5글자 초과 오류 테스트
    @Test
    void name_error_test1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("AAAAAA", "3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    //이름 공백 입력
    @Test
    void name_error_test2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(" ,aa", "3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    //시행 횟수 문자 오류 테스트
    @Test
    void try_error_test1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "a"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    //시행 횟수 유리수 오류 테스트
    @Test
    void try_error_test2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "3.3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    //시행 횟수 음수 오류 테스트
    @Test
    void try_error_test3() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "-3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    //시행 횟수 공백 오류 테스트
    @Test
    void try_error_test4() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", null))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    //시행 횟수 0입력
    @Test
    void try_error_test5() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "0"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    //시행 횟수 사이공백 입력
    @Test
    void try_error_test6() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "1 2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
