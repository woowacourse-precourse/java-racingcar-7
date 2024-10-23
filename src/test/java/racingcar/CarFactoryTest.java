package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

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



}