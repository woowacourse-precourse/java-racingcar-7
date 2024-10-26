package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;


@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class WinnerTest {

    @Test
    void 우승자_한명_테스트() {
        //given
        Winner winner = new Winner();
        Car car1 = new Car("theo");
        Car car2 = new Car("pobi");
        car1.move();

        List<Car> cars = List.of(car1, car2);

        //when
        winner.result(cars);

        //then
        assertThat(winner.getWinners()).containsExactly("theo");
    }

    @Test
    void 우승자_여러명_테스트() {
        //given
        Winner winner = new Winner();
        Car car1 = new Car("theo");
        Car car2 = new Car("pobi");
        car1.move();
        car2.move();

        List<Car> cars = List.of(car1, car2);

        //when
        winner.result(cars);

        //then
        assertThat(winner.getWinners()).containsExactly("theo", "pobi");
    }
}
