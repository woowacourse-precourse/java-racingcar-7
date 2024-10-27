package racingcar.racing;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.Assertions;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.car.Car;

class RacingControllerTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    private final RacingController racingController = new RacingController();

    @Test
    void 경주_진행() {
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Car car = new Car("name" + i);
            carList.add(car);
        }

        String input = "1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Assertions.assertRandomNumberInRangeTest(
                () -> {
                    racingController.start(carList);
                    assertThat(out.toString()).contains("name0 : -", "name1 : ", "name2 : -");
                    assertThat(out.toString()).contains("최종 우승자 : name0, name2");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD
        );
    }

}