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
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 이름에_대한_예외_처리_다섯자_이상(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("한동근두동근,세동근네동근", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름에_대한_예외_처리_쉼표_없음() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("동근 동근 동근", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름에_대한_예외_처리_쉼표_여러개() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("동근,,,동근", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 시도_횟수에_대한_예외_처리_빈_값() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("동근,동글", " "))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 시도_횟수에_대한_예외_처리_문자열_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("동근,동글", "한번"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 시도_횟수에_대한_예외_처리_문자열과_숫자() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("동근,동글", "1a2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 시도_횟수에_대한_예외_처리_음수() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("동근,동글", "-10"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
