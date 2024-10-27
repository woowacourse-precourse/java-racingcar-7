package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.*;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

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
    void 이름_분류_테스트(){
        //given
        InputManager inputManager = new ConsoleInputManager();
        List<String> comparisonValue = Arrays.asList("pobi", "woni");

        //when
        List<String> classifiedName = inputManager.splitName("pobi,woni");

        //then
        assertEquals(comparisonValue, classifiedName, "결과는 {pobi,woni}여야 합니다.");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
