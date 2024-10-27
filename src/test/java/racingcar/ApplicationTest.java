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

        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : -", "최종 우승자 : pobi, woni");
                },
                MOVING_FORWARD, MOVING_FORWARD
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
    @DisplayName("정상적인 입력")
    void 자동차_횟수_입력_테스트() {
        assertSimpleTest(() -> {
            run("poby,woni,jun", "3");
            assertThat(output())
                    .contains("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)", "시도할 횟수는 몇 회인가요?");
        });
    }

    @Test
    @DisplayName("자동차 이름이 5글자를 초과")
    void 자동차_이름_5글자_이상() {
        assertThatThrownBy(() -> {
            run("poby,woni,abcdef", "3");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 5자 이하로 입력 해야합니다.");
    }

    @Test
    @DisplayName("이름을 입력하지 않았을 때")
    void 자동차_이름_입력하지않았을때() {
        assertThatThrownBy(() -> {
            run("", "3");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름이 입력되지 않았습니다.");
    }

    @Test
    @DisplayName("공백을 포함했을 때")
    void 자동차_이름_공백포함() {
        assertThatThrownBy(() -> {
            run(" poby,woni,jun", "3");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("공백을 포함하면 안됩니다.");
    }

    @Test
    @DisplayName("자동차 이름이 중복될 경우")
    void 자동차_이름_중복() {
        assertThatThrownBy(() -> {
            run("poby,woni,poby", "3");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 중복되면 안됩니다.");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
