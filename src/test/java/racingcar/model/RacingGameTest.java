package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;


public class RacingGameTest {

    @Test
    void 자동차들이_전진_조건을_실행하는지_테스트() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("pobi"));
        cars.add(new Car("woni"));
        cars.add(new Car("jun"));

        RacingGame.playRace(cars, 4);
        RacingGame.playRace(cars, 5);

        assertThat(cars.get(0).getPosition()).isEqualTo(2);
    }
}
