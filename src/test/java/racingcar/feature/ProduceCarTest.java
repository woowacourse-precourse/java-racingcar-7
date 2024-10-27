package racingcar.feature;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.obj.Car;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class ProduceCarTest {

    ProduceCar produceCar = new ProduceCar();

    @Test
    void 레이싱카_생성_테스트() {
        List<Car> cars = produceCar.getCars(new String[]{"1번", "2번", "3번"});

        assertThat(cars.size()).isEqualTo(3);

    }
}
