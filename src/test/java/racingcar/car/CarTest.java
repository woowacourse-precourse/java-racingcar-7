package racingcar.car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    private PrintStream standardOut;
    private OutputStream captor;

    @BeforeEach
    void init() {
        standardOut = System.out;
        captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
    }

    @AfterEach
    void rollback() {
        System.setOut(standardOut);
    }

    @DisplayName("랜덤 값이 4 이상일 경우 자동차는 전진해야 한다.")
    @Test
    void canMoveCar() {
        //given
        String name = "car1";
        Car car = new Car(name);
        int randomValue = 4;

        //when
        car.attemptMove(randomValue);
        car.attemptMove(randomValue);
        car.showStatus();
        String result = getOutput();

        //then
        assertThat(result).isEqualTo(name + " : " + "--");
    }

    @DisplayName("랜덤값이 4 미만일 경우 자동차는 전진하지 않는다.")
    @Test
    void test() {
        //given
        String name = "car1";
        Car car = new Car(name);
        int randomValue = 3;

        //when
        car.attemptMove(randomValue);
        car.attemptMove(randomValue);
        car.showStatus();
        String result = getOutput();

        //then
        assertThat(result).isEqualTo(name + " :");
    }

    private String getOutput() {
        return captor.toString().trim();
    }
}