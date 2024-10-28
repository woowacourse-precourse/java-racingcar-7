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
    @DisplayName("자동차 이름 빈 문자열 입력")
    void emptyCarName(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("중복된 자동차 이름 입력")
    void duplicateCarName(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,jun,pobi", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("자동차 이름에 공백 포함")
    void blankCarName(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,jun jun,woni", "3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("쉼표가 아닌 구분자 사용")
    void notComma(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,jun!woni", "3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("시도할 횟수 0 혹은 음수")
    void inputZeroOrNegativeInt(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,jun,woni", "-3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("시도할 횟수 문자 입력")
    void inputCharacter(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,jun,woni", "abc"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("시도할 횟수 빈 문자열 입력")
    void emptyCountValue(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,jun,woni", " "))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
