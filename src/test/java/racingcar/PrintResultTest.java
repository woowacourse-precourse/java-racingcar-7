package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

public class PrintResultTest extends NsTest {
    private static final int MOVING_FORWARD = 4;

    PrintResult printResult = new PrintResult();

    @Test
    void 전진횟수만큼_bar출력_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    Car pobi = new Car("pobi");

                    pobi.move();
                    pobi.move();

                    printResult.printCar(pobi);

                    assertThat(output()).contains("pobi : --");

                },
                MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    void 최종우승자_출력_테스트() {
        List<String> carName = List.of("pobi", "woni");
        printResult.printWinner(carName);
        assertThat(output()).contains("최종 우승자 : pobi, woni");
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
