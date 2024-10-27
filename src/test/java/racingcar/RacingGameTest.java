package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.car.Car;

class RacingGameTest {

    @Test
    @DisplayName("각 차수마다 자동차들의 위치 상태를 출력한다")
    void showCarVisualStatusForEachTrialTest() {
        // given
        RacingGame racingGame = new RacingGame();
        Car t1 = Car.from("t1");
        Car t2 = Car.from("t2");
        Car t3 = Car.from("t3");

        t1.tryMoveForward(3, 1);
        t2.tryMoveForward(4, 1);
        t3.tryMoveForward(4, 1);

        List<Car> cars = List.of(
                t1, t2, t3
        );

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));

        // when
        racingGame.showCarsStatusForEachTrial(cars);

        // then
        assertThat(byteArrayOutputStream.toString()).isEqualTo(
                "t1 : " + System.lineSeparator() + "t2 : -" + System.lineSeparator() + "t3 : -"
                        + System.lineSeparator() + System.lineSeparator()
        );

        System.setOut(System.out);
    }

}