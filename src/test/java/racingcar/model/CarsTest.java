package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class CarsTest {
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
