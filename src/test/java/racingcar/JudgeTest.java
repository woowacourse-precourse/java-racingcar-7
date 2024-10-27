package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class JudgeTest {
    Judge judge = new Judge();

    @Test
    void 우승자_반환() {
        Car testCar1 = new Car("test1");
        Car testCar2 = new Car("test1");
        List<Car> testCars = List.of(testCar1, testCar2);

        testCar1.move();
        assertThat(judge.getWinners(testCars)).isEqualTo(List.of(testCar1));

        testCar2.move();
        assertThat(judge.getWinners(testCars)).isEqualTo(List.of(testCar1, testCar2));
    }
}