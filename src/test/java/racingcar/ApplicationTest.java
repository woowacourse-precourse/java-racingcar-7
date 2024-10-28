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
    void 길이_예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 문자열_공백포함_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(" pobi,java", "1"))
                        .isInstanceOf(IllegalArgumentException.class));

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("po bi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class));

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi ,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class));

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi, javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class));

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("d  , javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class));

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,    ,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class));

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi, javaji ", "1"))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 쉼표_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi", "1"))
                        .isInstanceOf(IllegalArgumentException.class));

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(",pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class));

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,", "1"))
                        .isInstanceOf(IllegalArgumentException.class));

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji,", "1"))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 자동차_이름_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("[],안녕", "1"))
                        .isInstanceOf(IllegalArgumentException.class));

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,?123", "1"))
                        .isInstanceOf(IllegalArgumentException.class));

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("javaji,&", "1"))
                        .isInstanceOf(IllegalArgumentException.class));

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("안녕,$%", "1"))
                        .isInstanceOf(IllegalArgumentException.class));

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("ㄱ,ㄴ,ㄷ,ㄹ,ㅁ,^^", "1"))
                        .isInstanceOf(IllegalArgumentException.class));

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("안녕,안녕", "1"))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 시도할_횟수_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1.0"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1.5"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "-1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "0"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "-1.56"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1회"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1 "))
                        .isInstanceOf(IllegalArgumentException.class)
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", " 1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
