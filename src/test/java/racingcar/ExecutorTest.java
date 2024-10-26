package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class ExecutorTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    IOController ioController = new IOController();
    Parser parser = new Parser();
    Validator validator = new Validator();
    Executor executor = new Executor(ioController, parser, validator);

    @Test
    void 우승자_반환() {
        Car t1 = new Car("t1");
        Car t2 = new Car("t2");
        Car t3 = new Car("t3");

        t1.move();

        List<Car> test = new ArrayList<>(List.of(t1, t2, t3));
        List<Car> expected1 = new ArrayList<>(List.of(t1));

        assertThat(executor.getWinners(test)).isEqualTo(expected1);

        t2.move();

        List<Car> expected2 = new ArrayList<>(List.of(t1, t2));
        assertThat(executor.getWinners(test)).isEqualTo(expected2);
    }
}