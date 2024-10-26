package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CarFactoryTest {
    private final CarFactory carFactory = new CarFactory(",");

    @Test
    void 차_목록_생성() {
        //given
        String[] carNames = {"benz","audi","bmw","kia","tesla"};

        //when
        List<Car> cars = carFactory.getCars(carNames);

        //then
        assertThat(cars.size()).isEqualTo(5);
    }




}