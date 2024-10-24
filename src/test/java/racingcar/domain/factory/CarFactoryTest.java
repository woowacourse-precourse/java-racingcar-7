package racingcar.domain.factory;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

class CarFactoryTest {
    private final CarFactory carFactory = new CarFactory(",");

    @Test
    void 차_목록_생성() {
        //given
        String input = "benz,audi,bmw,kia,tesla";

        //when
        List<Car> cars = carFactory.getCars(input);

        //then
        assertThat(cars.size()).isEqualTo(5);
    }

    @Test
    void 차_목록_생성_실패_중복된_이름() {
        //given
        String input = "benz,bmw,audi,bmw";

        //then
        Assertions.assertThrows(IllegalArgumentException.class, () -> carFactory.getCars(input));
    }



}