package racingcar;

import static console.Message.OUTPUT_SEPARATOR;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

    @DisplayName("makeHyphen 함수가 advanceCount과 동일한 Hyphen을 출력하는지 확인")
    @Test
    void makeHyphenTest() {
        String carName = "testCar";

        Car car = new Car(carName);

        assertThat("").isEqualTo(car.makeHyphen());

        car.addAdvanceCount();

        assertThat("-").isEqualTo(car.makeHyphen());

        car.addAdvanceCount();

        assertThat("--").isEqualTo(car.makeHyphen());
    }

    @DisplayName("printRacingInfo 함수가 중간출력을 정상적으로 하는지 확인")
    @Test
    void printRacingInfoTest() {
        String carName = "testCar";
        Car car = new Car(carName);
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        String expectedOutput = carName + OUTPUT_SEPARATOR + car.makeHyphen() + "\r\n";

        car.printRacingInfo();

        assertThat(outContent.toString()).isEqualTo(expectedOutput);
        // 원래 출력 스트림 복원
        System.setOut(System.out);
    }

}
