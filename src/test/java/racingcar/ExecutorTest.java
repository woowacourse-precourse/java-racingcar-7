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
    Executor executor = new Executor(ioController, parser, validator);

    Car testCar1, testCar2, testCar3;
    List<Car> testCarList;

    @BeforeEach
    void setUp() {
        testCar1 = new Car("test1");
        testCar2 = new Car("test2");
        testCar3 = new Car("test3");
        testCarList = new ArrayList<>(List.of(testCar1, testCar2, testCar3));
    }

    @Test
    void 특정_횟수만큼_반복해서_자동차_이동() {
        assertRandomNumberInRangeTest(
            () -> {
                executor.executeForCount(testCarList, 2);
                assertThat(testCar1.getMoveCount()).isEqualTo(1);
                assertThat(testCar2.getMoveCount()).isEqualTo(1);
                assertThat(testCar3.getMoveCount()).isEqualTo(2);
            },
            MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
            STOP, STOP, MOVING_FORWARD
        );
    }

    @Test
    void 자동차_이동() {
        assertRandomNumberInRangeTest(
            () -> {
                executor.moveCar(testCar1);
                assertThat(testCar1.getMoveCount()).isEqualTo(1);
            },
            MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    void 자동차_여러대_이동() {
        assertRandomNumberInRangeTest(
            () -> {
                executor.moveCars(testCarList);
                assertThat(testCar1.getMoveCount()).isEqualTo(1);
                assertThat(testCar2.getMoveCount()).isEqualTo(1);
                assertThat(testCar3.getMoveCount()).isEqualTo(0);
            },
            MOVING_FORWARD, MOVING_FORWARD, STOP
        );
    }

    @Test
    void 우승자_반환() {
        testCar1.move();
        assertThat(executor.getWinners(testCarList)).isEqualTo(List.of(testCar1));

        testCar2.move();
        assertThat(executor.getWinners(testCarList)).isEqualTo(List.of(testCar1, testCar2));
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