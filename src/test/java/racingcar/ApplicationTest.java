package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;
    private static final Application.CarRacing carRacing = new Application.CarRacing();

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
    void convertCarNamesTest(){
        assertSimpleTest(() -> {
            ArrayList<String> resultNames = carRacing.convertCarNames("pobi,woni,jun");
            assertThat(resultNames).contains("pobi","woni","jun");
        });
    }

    @Test
    void 예외_convertCarNamesTest(){
        assertSimpleTest(() -> {
            assertThatThrownBy(()-> carRacing.convertCarNames("pobi;woni,jun")).isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void convertAttemptsTest(){
        assertSimpleTest(() -> {
            int resultCount = carRacing.convertAttempts("4");
            assertThat(resultCount).isEqualTo(4);
        });
    }

    @Test
    void 예외_convertAttemptsTest(){
        assertSimpleTest(() -> {
            assertThatThrownBy(()-> carRacing.convertAttempts("")).isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
