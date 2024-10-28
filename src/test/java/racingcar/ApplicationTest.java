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
    void functionTest() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni\n1");
                    assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void minusTest() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> run("pobi,woni\n-1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("시도 횟수는 1 이상이어야 합니다.")
        );
    }

    @Test
    void overFiveCharTest() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> run("pobi,bookqeukgom\n3"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("자동차의 이름은 5글자 이하여야 합니다.")
        );
    }

    @Test
    void blankNameTest() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> run("\n2"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("이름은 비어있을 수 없습니다.")
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
