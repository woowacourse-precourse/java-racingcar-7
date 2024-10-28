package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 올바른_작동_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "2");
                    assertThat(output()).contains("pobi : --", "woni : -", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP,
                MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    void 자동차_빈값_전달_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi, ", "2"))
                        .isInstanceOf(IllegalArgumentException.class)
                                .hasMessage("자동차 이름이 빈 값일 수 없습니다.")
        );
    }

    @Test
    void 자동차_이름_5글자_초과_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "2"))
                        .isInstanceOf(IllegalArgumentException.class)
                                .hasMessage("자동차 이름은 5글자를 초과할 수 없습니다.")
        );
    }

    @Test
    void 자동차_이름_중복_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,pobi", "2"))
                        .isInstanceOf(IllegalArgumentException.class)
                                .hasMessage("중복된 이름입니다.")
        );
    }

    @Test
    void 자동차_2대가_아니라면_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi", "3"))
                        .isInstanceOf(IllegalArgumentException.class)
                                .hasMessage("자동차는 2대 이상 입력해주세요.")
        );
    }

    @Test
    void 시도_횟수_빈_값_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", " "))
                        .isInstanceOf(IllegalArgumentException.class)
                                .hasMessage("시도할 횟수는 빈 값일 수 없습니다.")
        );
    }

    @Test
    void 시도_횟수_숫자인지_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "oi"))
                        .isInstanceOf(IllegalArgumentException.class)
                                .hasMessage("시도할 횟수에 숫자만 입력해주세요.")
        );
    }

    @Test
    void 시도_1회_이상인지_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "0"))
                        .isInstanceOf(IllegalArgumentException.class)
                                .hasMessage("시도할 횟수는 1회 이상으로 입력해주세요.")
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
