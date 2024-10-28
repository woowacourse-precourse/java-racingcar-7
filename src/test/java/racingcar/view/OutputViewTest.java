package racingcar.view;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class OutputViewTest extends NsTest {

    private Car car1;
    private Car car2;

    @BeforeEach
    void setUp() {
        car1 = new Car("pobi");
        car2 = new Car("woni");
        car1.addMove();
    }

    @Test
    void printResult_test() {
        OutputView.printResult(Arrays.asList(car1, car2));
        assertThat(output()).contains("pobi : -", "woni :", "\n");
    }

    @Test
    void sole_printWinner_test() {
        OutputView.printWinner(Arrays.asList(car1, car2));
        assertThat(output()).contains("최종 우승자 : pobi, woni");
    }

    @Test
    void multi_printWinner_test() {
        OutputView.printWinner(Arrays.asList(car1));
        assertThat(output()).contains("최종 우승자 : pobi");
    }

    @Override
    protected void runMain() {}
}