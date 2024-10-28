package racingcar.model;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.BeforeEach;

class CarsTest {

    private Car car1;
    private Car car2;
    private Cars cars;

    @BeforeEach
    void setUp() {
        car1 = new Car("pobi");
        car2 = new Car("crong");
        cars = new Cars(List.of(car1, car2));
    }

    @Test
    void 모든_자동차_이동() {
        car1.move(5);
        car2.move(3);
        assertThat(car1.getPosition()).isEqualTo(5);
        assertThat(car2.getPosition()).isEqualTo(0);
    }


    @Test
    void 우승자_확인() {
        car1.move(5);
        car2.move(5);
        List<String> winners = cars.getWinners();
        assertThat(winners).containsExactlyInAnyOrder("pobi", "crong");
    }
}
