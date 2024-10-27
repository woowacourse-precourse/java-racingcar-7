package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IOControllerTest extends NsTest {
    IOController ioController = new IOController();
    Car testCar1, testCar2, testCar3;
    List<Car> testCars;

    @BeforeEach
    void setUp() {
        testCar1 = new Car("test1");
        testCar2 = new Car("test2");
        testCar3 = new Car("test3");
        testCars = List.of(testCar1, testCar2, testCar3);
    }

    @Test
    void 결과_출력(){
        testCar3.move();
        ioController.printResults(testCars);
        assertThat(output()).contains("test1 : ", "test2 : ", "test3 : -");
    }

    @Test
    void 자동차별_결과_출력() {
        testCar1.move();
        testCar1.move();
        ioController.printResultByCar(testCar1.getName(), testCar1.getMoveCount());
        assertEquals("test1 : --", output());
    }

    @Test
    void 우승자_출력() {
        ioController.printWinners(List.of(testCar3));
        assertEquals("최종 우승자 : test3", output());
    }

    @Override
    protected void runMain() {
    }
}