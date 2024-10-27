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

    @DisplayName("최종 우승자가 여러명일 경우 우승자 이름 사이 콤마와 공백이 포함되어야 한다.")
    @Test
    void manyWinner() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,woo", "1");
                    assertThat(output()).contains("pobi : -", "woni : ", "woo : -", "최종 우승자 : pobi, woo");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD
        );
    }

    @DisplayName("빈 문자열이 들어오면 안된다.")
    @Test
    void emptyInputTest() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("중복된 이름이 들어오면 안된다.")
    @Test
    void duplicateNameTest() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("java, woowa, java", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("이름의 길이는 5 이하만 가능하다.")
    @Test
    void nameLengthTest() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("java, woowa, 123456", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("이름은 빈 문자열이 될 수 없다.")
    @Test
    void emptyNameTest() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("java, woowa,,      ,java", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("이름은 2개 이상 들어와야 한다.")
    @Test
    void test() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("woowa"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
