package racingcar.car;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class RacingCarControllerTest {

    private final RacingCarController racingCarController = new RacingCarController();

    @Test
    void 자동차_생성() {
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Car car = new Car("name" + i);
            carList.add(car);
        }

        String input = "name0,name1,name2";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        List<Car> result = racingCarController.registerRacingCars();

        for(int num = 0; num < 3; num++) {
            assertThat(result.get(num).getName()).isEqualTo(carList.get(num).getName());
        }
    }
}