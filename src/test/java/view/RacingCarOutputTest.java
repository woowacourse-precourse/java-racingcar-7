package view;

import org.junit.jupiter.api.Test;
import racingcar.domain.RacingCar;
import racingcar.view.RacingCarOutput;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarOutputTest {
    RacingCarOutput racingCarOutput = new RacingCarOutput();

    @Test
    void 현재상황_출력_테스트() {
        RacingCar car1 = new RacingCar("Car1");
        car1.moveForward();
        car1.moveForward();

        RacingCar car2 = new RacingCar("Car2");
        car2.moveForward();


        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));

        racingCarOutput.printCurrentScore(List.of(car1,car2));
        assertThat(byteArrayOutputStream.toString())
                .isEqualTo("Car1 : --" + System.lineSeparator() + "Car2 : -" + System.lineSeparator().repeat(2));
    }

}