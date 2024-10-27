package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.test.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.car.Car;

class ResponseTest {

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    List<Car> carList = new ArrayList<>();

    @BeforeEach
    void 자동차_리스트() {
        for (int i = 0; i < 3; i++) {
            Car car = new Car("name" + i);
            carList.add(car);
        }

        Assertions.assertRandomNumberInRangeTest(
                () -> {
                    for (Car car : carList) {
                        car.forward();
                    }
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD
        );
    }

    @Test
    void 실행_과정_출력() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Response.outputExecute(carList);
        assertThat(out.toString()).contains("name0 : -", "name1 : ", "name2 : -");
    }

    @Test
    void 우승자_출력() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Response.outputFinalWinner(carList);
        assertThat(out.toString()).contains("최종 우승자 : name0, name1, name2");
    }
}