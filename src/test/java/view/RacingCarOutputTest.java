package view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.RacingCar;
import racingcar.view.RacingCarOutput;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarOutputTest {
    private RacingCarOutput racingCarOutput = new RacingCarOutput();
    private ByteArrayOutputStream byteArrayOutputStream;
    private PrintStream standardOut;

    @BeforeEach
    void setUp() {
        this.standardOut = System.out;
        byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));
    }

    @AfterEach
    void tearDown() {

        System.setOut(standardOut);
        System.out.println(byteArrayOutputStream.toString().trim());
    }

    @Test
    void 현재상황_출력_테스트() {
        RacingCar car1 = new RacingCar("Car1");
        car1.moveForward();
        car1.moveForward();

        RacingCar car2 = new RacingCar("Car2");
        car2.moveForward();

        racingCarOutput.printCurrentScore(List.of(car1, car2));
        assertThat(byteArrayOutputStream.toString())
                .isEqualTo("Car1 : --" + System.lineSeparator() + "Car2 : -"
                        + System.lineSeparator().repeat(2));
    }

    @Test
    void 우승자_출력_테스트() {
        RacingCar car1 = new RacingCar("Car1");
        car1.moveForward();
        car1.moveForward();

        RacingCar car2 = new RacingCar("Car2");
        car2.moveForward();
        car2.moveForward();

        racingCarOutput.printWinners(List.of(car1, car2));
        assertThat(byteArrayOutputStream.toString())
                .isEqualTo("최종 우승자 : Car1, Car2");
    }

}