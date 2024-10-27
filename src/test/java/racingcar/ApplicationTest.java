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
    void 시도횟수_1회_미만으로_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("venus,luca", "0"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 경주에_참여할_자동차의_이름을_1대_이하로_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("venus", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 입력받은_자동차_이름에_사이에_쉼표_2개_이상_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("venus,,luca,pobi", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 입력받은_자동차_이름에_공백_존재() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("venus  ,luca,pobi", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 부적절한_문자_포함여부_검증() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("venus:luca", "2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
