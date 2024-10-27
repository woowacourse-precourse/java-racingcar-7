package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ExecutorTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    IOController ioController = new IOController();
    Parser parser = new Parser();
    Validator validator = new Validator();
    Racing racing = new Racing();
    Executor executor = new Executor(ioController, parser, validator, racing);

    Car testCar1, testCar2, testCar3;
    List<Car> testCars;

    @BeforeEach
    void setUp() {
        testCar1 = new Car("test1");
        testCar2 = new Car("test2");
        testCar3 = new Car("test3");
        testCars = new ArrayList<>(List.of(testCar1, testCar2, testCar3));
    }

    @Test
    void 우승자_반환() {
        testCar1.move();
        assertThat(executor.getWinners(testCars)).isEqualTo(List.of(testCar1));

        testCar2.move();
        assertThat(executor.getWinners(testCars)).isEqualTo(List.of(testCar1, testCar2));
    }

    @Test
    void 실행() {
        long repeatCount;
        List<Car> cars = new ArrayList<>();
        List<Car> winners = new ArrayList<>();

        assertRandomNumberInRangeTest(
            () -> {
                run("car1,car2,car3", "1");
                Assertions.assertThat(output())
                    .contains("car1 : -", "car2 : ", "car3 : -", "최종 우승자 : car1, car3");
            },
            MOVING_FORWARD, STOP, MOVING_FORWARD
        );
    }

    @Override
    public void runMain() {
        executor.run();
    }
}