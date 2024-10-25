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
                    run("pobi,theo", "1");
                    assertThat(output()).contains("pobi : -", "theo : ", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 두명_공동_우승_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,theo", "1");
                    assertThat(output()).contains("pobi : -", "theo : -", "최종 우승자 : pobi, theo");
                },
                MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    void 세명_공동_우승_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,theo,park", "1");
                    assertThat(output()).contains("pobi : -", "theo : -", "park : -", "최종 우승자 : pobi, theo, park");
                },
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
        );
    }


    @Test
    void 자동차_길이_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,theopk", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("자동차의 이름은 최대 5자까지 허용됩니다.")
        );
    }

    @Test
    void 공백_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("", ""))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("입력이 비어있습니다.")
        );
    }

    @Test
    void 부분_공백_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("theo, ,pobi", ""))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("입력이 비어있습니다.")
        );
    }

    @Test
    void 중복_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("theo,theo", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("자동차의 이름이 중복되었습니다.")
        );
    }

    @Test
    void 자동차_물량_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,2,3,4,5,6,7,8,9,10,11", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("자동차는 10대까지 허용됩니다.")
        );
    }

    @Test
    void 문자열_끝_구분자_입력_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("theo,", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("문자열의 끝에 구분자가 위치해있습니다.")
        );
    }

    @Test
    void 최대_실행_횟수_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("theo,pobi", "11"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("이동 횟수는 10회까지 허용됩니다.")
        );
    }

    @Test
    void 최소_실행_횟수_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("theo,pobi", "0"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("1회 이상 이동해야합니다.")
        );
    }

    @Test
    void 횟수_입력_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("theo,pobi", "theo"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("정수를 입력해주세요.")
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
