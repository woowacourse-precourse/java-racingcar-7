package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Name;
import racingcar.domain.NumberGenerator;
import racingcar.domain.Racing;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class RacingTest extends NsTest {

    @Test
    void 자동차는_4_이상일때_움직인다() {
        NumberGenerator generator = () -> 4;
        Car car = new Car(Name.from("ckw"), generator);

        car.move();

        assertThat(car.getDistance()).isEqualTo(1);
    }

    @Test
    void 자동차는_3_이하일때_멈춘다() {
        NumberGenerator generator = () -> 3;
        Car car = new Car(Name.from("ckw"), generator);

        car.move();

        assertThat(car.getDistance()).isEqualTo(0);
    }

    @Test
    void 우승자를_알아낸다() {
        NumberGenerator generator1 = () -> 5;
        NumberGenerator generator2 = () -> 3;

        Car car1 = new Car(Name.from("ckw"), generator1);
        Car car2 = new Car(Name.from("ygd"), generator2);

        Racing racing = new Racing(List.of(car1, car2));

        racing.race();

        List<String> winners = racing.findWinners();
        assertThat(winners).containsExactly("ckw");
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
