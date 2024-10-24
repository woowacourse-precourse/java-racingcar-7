package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.util.randomnumber.RandomNumberGenerator;
import racingcar.util.randomnumber.StubRandomNumberGenerator;

class RacingTest {

    @DisplayName("경주를 생성한다.")
    @Test
    void createRacing() {
        //given
        Cars cars = Cars.from(List.of(
                Car.from("pobi", new RandomNumberGenerator()),
                Car.from("woni", new RandomNumberGenerator()),
                Car.from("jun", new RandomNumberGenerator())
        ));

        //when
        Racing racing = Racing.from(cars);

        //then
        assertThat(racing).isEqualTo(Racing.from(cars));
    }

    @DisplayName("경주를 진행한다.")
    @Test
    void runRacing() {
        //given
        Car pobiCar = Car.from("pobi", new StubRandomNumberGenerator(4));
        Car woniCar = Car.from("woni", new StubRandomNumberGenerator(3));
        Car junCar = Car.from("jun", new StubRandomNumberGenerator(1));

        Cars cars = Cars.from(
                List.of(pobiCar, woniCar, junCar)
        );

        Racing racing = Racing.from(cars);

        //when
        racing.runRacing();

        //then
        assertThat(pobiCar.getPosition()).isEqualTo(1);
        assertThat(woniCar.getPosition()).isEqualTo(0);
        assertThat(junCar.getPosition()).isEqualTo(0);
    }
}