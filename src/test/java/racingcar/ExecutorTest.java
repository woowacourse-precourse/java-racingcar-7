package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ExecutorTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    IOController ioController = new IOController();
    Parser parser = new Parser();
    Validator validator = new Validator();
    Executor executor = new Executor(ioController, parser, validator);

    Car testCar1, testCar2, testCar3;

    @BeforeEach
    void setUp() {
        testCar1 = new Car("test1");
        testCar2 = new Car("test2");
        testCar3 = new Car("test3");
    }

    @Test
    void 우승자_반환() {
        List<Car> test = new ArrayList<>(List.of(testCar1, testCar2, testCar3));

        testCar1.move();
        List<Car> expected1 = new ArrayList<>(List.of(testCar1));
        assertThat(executor.getWinners(test)).isEqualTo(expected1);

        testCar2.move();
        List<Car> expected2 = new ArrayList<>(List.of(testCar1, testCar2));
        assertThat(executor.getWinners(test)).isEqualTo(expected2);
    }
}