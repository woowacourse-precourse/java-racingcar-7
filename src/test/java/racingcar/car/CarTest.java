package racingcar.car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static racingcar.car.ErrorMessage.EMPTY_STRING_NAME_ERROR_MESSAGE;
import static racingcar.car.ErrorMessage.NAME_LENGTH_ERROR_MESSAGE;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;
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

    @DisplayName("차의 이름으로 빈 문자열이 들어올 수 없다.")
    @Test
    void emptyStringName() {
        //given
        String name = "";

        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(EMPTY_STRING_NAME_ERROR_MESSAGE);
    }

    @DisplayName("")
    @Test
    void nameSizeOverFive() {
        //given
        String name = "123456";

        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NAME_LENGTH_ERROR_MESSAGE);
    }

    @DisplayName("랜덤 값이 4 이상일 경우 자동차는 전진해야 한다.")
    @Test
    void canMoveCar() {
        //given
        String name = "car1";
        Car car = new Car(name);
        List<Integer> randomValues = List.of(4, 3, 5 ,1);
        int attemptCount = 3;

        for(int i = 0 ; i < attemptCount; i++) {
            car.attemptMoving(randomValues.get(i));
        }

        //when
        int moveCount = car.getMoveCount();

        //then
        assertThat(moveCount).isEqualTo(2);
    }

    @DisplayName("랜덤값이 4 미만일 경우 자동차는 전진하지 않는다.")
    @Test
    void test() {
        //given
        String name = "car1";
        Car car = new Car(name);
        int randomValue = 3;

        //when
        car.attemptMoving(randomValue);
        car.attemptMoving(randomValue);
        car.showStatus();
        String result = getOutput();

        //then
        assertThat(result).isEqualTo(name + " :");
    }

    private String getOutput() {
        return captor.toString().trim();
    }
}