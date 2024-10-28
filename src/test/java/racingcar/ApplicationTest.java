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
    void 기본_기능_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 중복_우승_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : -", "최종 우승자 : pobi, woni");
                },
                MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    void 공백_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi, "))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("공백인 이름이 있습니다.")
        );
    }

    @Test
    void 참가자_1인_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("2명 이상 입력해야 합니다.")
        );
    }

    @Test
    void 이름_글자_초과_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,pobibi"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("5글자를 초과한 이름이 있습니다.")
        );
    }

    @Test
    void 중복_입력_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,pobi"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("중복된 이름이 있습니다")
        );
    }

    @Test
    void 횟수_문자형_입력_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,pobi2", "a"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("시도 횟수는 숫자여야 합니다.")
        );
    }

    @Test
    void 횟수_0이하_입력_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,pobi2", "0"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("시도 횟수는 1 이상이어야 합니다.")
        );
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
