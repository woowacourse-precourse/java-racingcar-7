package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {

    @DisplayName("Cars가 주어졌을 때, 가장 많이 움직인 자동차를 우승자로 뽑는다 - 단독 우승의 경우")
    @Test
    void find_winner_test(){
        Car car1 = new Car("pobi");
        Car car2 = new Car("bibim");
        Car car3 = new Car("even");
        Cars cars = new Cars(List.of(car1, car2, car3));

        car1.move(9);
        car1.move(8);
        car2.move(0);
        car2.move(1);
        car3.move(0);
        car3.move(2);

        List<Car> winner = cars.findWinner(cars.getCars());
        assertThat(winner.size()).isEqualTo(1);
        assertThat(winner.get(0).getName()).isEqualTo("pobi");
        assertThat(winner.get(0).getMovedDistance()).isEqualTo(2);
    }

    @DisplayName("Cars가 주어졌을 때, 가장 많이 움직인 자동차를 우승자로 뽑는다 - 복수 우승의 경우")
    @Test
    void find_two_winner_test(){
        Car car1 = new Car("pobi");
        Car car2 = new Car("bibim");
        Car car3 = new Car("even");
        Cars cars = new Cars(List.of(car1, car2, car3));

        car1.move(9);
        car1.move(8);
        car2.move(0);
        car2.move(4);
        car3.move(9);
        car3.move(9);

        List<Car> expectedWinner = List.of(car1, car3);
        List<Car> winner = cars.findWinner(cars.getCars());
        assertThat(winner.size()).isEqualTo(2);
        assertThat(winner).containsAll(expectedWinner);
    }
}
