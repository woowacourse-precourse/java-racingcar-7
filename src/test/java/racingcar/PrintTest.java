package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PrintTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void positionTest() {
        assertSimpleTest(
                () -> {
                    Car car = new Car("name",2);
                    Print.position(car);
                    assertThat(output()).isEqualTo("name : --");
                }
        );
    }

    @Test
    void printUniqueWinnersTest() {
        assertSimpleTest(
                () -> {
                    ArrayList<String> winners = new ArrayList<String>();
                    winners.add("name");
                    Print.winners(winners);
                    assertThat(output()).isEqualTo("최종 우승자 : name");
                }
        );
    }

    @Test
    void printMultipleWinnersTest() {
        assertSimpleTest(
                () -> {
                    ArrayList<String> winners = new ArrayList<String>();
                    winners.add("delta");
                    winners.add("omega");
                    Print.winners(winners);
                    assertThat(output()).isEqualTo("최종 우승자 : delta, omega");
                }
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
