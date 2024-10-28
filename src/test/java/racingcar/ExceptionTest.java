package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

import camp.nextstep.edu.missionutils.test.NsTest;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class ExceptionTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;


    @Test
    void 자동차이름_공백_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 자동차이름_구분자_공백_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(", , ,", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 자동차이름_구분자_사이_공백_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(", , ,pobi", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Test
    void 자동차이름_길이_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("sldkfjlk, abd", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

    }

    @Test
    void 구분자_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(";", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 자동차_이름_다른_구분자_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi;woni;jun", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 시도_횟수_예외() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni,jun"," "))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Test
    void 한글_이름_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("한명,두명", "1");
                    assertThat(output()).contains("한명 : -", "두명 : ", "최종 우승자 : 한명");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 공동_우승_테스트() {
        assertSimpleTest(() -> {
            run("pobi,woni,jun","0");
            assertThat(output()).contains("최종 우승자 : "+"pobi, woni, jun");
        });
    }



    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
