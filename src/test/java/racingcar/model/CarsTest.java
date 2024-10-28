package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.util.RandomGenerator;

public class CarsTest {
    static Object[][] randomNumberAndExpected() {
        return new Object[][]{
                {0, 0},
                {3, 0},
                {4, 1},
                {9, 1}
        };
    }

    @ParameterizedTest
    @MethodSource("randomNumberAndExpected")
    void 랜덤_값이_4_이상이면_전진_미만이면_정지한다(int random, int expected) {
        RandomGenerator randomGenerator = () -> random;
        List<Car> carList = new CarList("pobi,woni");
        Car car = carList.getFirst();
        Cars cars = new Cars(carList, randomGenerator);

        cars.tryMoveAll();

        assertThat(car.getPosition()).isEqualTo(expected);
    }

    @Test
    void 자동차_경주_최종_우승자가_2명() {
        List<Car> carList = new CarList("pobi,woni,jun");
        Car car1 = carList.getFirst();
        Car car2 = carList.get(1);
        Car car3 = carList.get(2);
        Cars cars = new Cars(carList);

        car1.move(true);
        car2.move(false);
        car3.move(true);
        List<String> raceWinner = cars.getRaceWinner();

        assertThat(raceWinner).hasSize(2)
                .containsExactly("pobi", "jun");
    }
}
