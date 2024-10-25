package racingcar.model.car;

import racingcar.model.car.Car;
import racingcar.model.number.MoveNumber;
import racingcar.model.name.Name;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CarTest {
    @Test
    void 자동차_이동_테스트() {
        Car car = new Car("pobi");
        car.move(()-> {return 5;});
        assertThat(car).isEqualTo(new Car(new Name("pobi"),new MoveNumber(1)));
    }

}
