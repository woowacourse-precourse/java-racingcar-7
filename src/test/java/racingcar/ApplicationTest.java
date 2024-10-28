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
    @Test
    @DisplayName("공백만으로 생성된 이름")
    void 이름공백_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("   ,pobi", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    @DisplayName("공백으로 시작된 이름")
    void 이름공백시작_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(" user,pobi", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("이름 길이가 5이상 일때")
    void 이름길이5이상_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("hello world,pobi", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    @DisplayName("이름에 이스케이프 문자가 포함되었을때")
    void 이름이스케이프포함_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("\njun,may", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("이동횟수가 문자일때")
    void 이동횟수문자_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(" user,pobi", "hello"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
