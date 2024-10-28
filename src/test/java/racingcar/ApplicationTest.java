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
    void 이름_5자_초과_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("audi,chevrolet", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("이름은 1자 이상 5자 이하로 입력해야 합니다.")
        );
    }

    @Test
    void 잘못된_문자_포함_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("audi,#ford", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("이름은 영어와 숫자만 입력 가능합니다.")
        );
    }

    @Test
    void 입력값_누락_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("입력값이 존재하지 않습니다.")
        );
    }

    @Test
    void 시도_횟수_0_음수_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("audi,ford", "0"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("시도 횟수는 1회 이상으로 입력해야 합니다.")
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("audi,ford", "-1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("시도 횟수는 1회 이상으로 입력해야 합니다.")
        );
    }

    @Test
    void 자동차_이동_조건_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("audi,ford", "5");
                    assertThat(output()).contains("audi : -", "ford : -");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD, STOP, MOVING_FORWARD
        );
    }

    @Test
    void 공동_우승자_출력_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("audi,ford", "3");
                    assertThat(output()).contains("최종 우승자 : audi, ford");
                },
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
