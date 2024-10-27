package racingcar.model;

import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RaceCarsTest {
    @Test
    @DisplayName("RaceCars 객체를 생성할 수 있다.")
    void createRaceCars() {
        //given
        Name name1 = new Name("우테코");
        Name name2 = new Name("박재연");
        Car car = new Car(name1);
        Car car2 = new Car(name2);
        List<Car> cars = Arrays.asList(car, car2);
        //when
        RaceCars raceCars = new RaceCars(cars);
        //then
        Assertions.assertThat(raceCars).isNotNull();
    }

}