package racingcar.view;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

class UserInterfaceTest {

    @Test
    void 단독우승_출력_성공() {
        // given
        Car car1 = new Car("car1");
        List<Car> winners = List.of(car1);
        UserInterface userInterface = new UserInterface();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // when
        userInterface.showFinalWinner(winners);

        // then
        String expectedOutput = "최종 우승자 : " + "car1" + System.lineSeparator();
        assertEquals(expectedOutput, outputStream.toString());
    }


    @Test
    void 공동우승_출력_성공() {
        // given
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        Car car3 = new Car("car3");
        List<Car> winners = Arrays.asList(car1, car2, car3);
        UserInterface userInterface = new UserInterface();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // when
        userInterface.showFinalWinner(winners);

        // then
        String expectedOutput = "최종 우승자 : " + "car1, car2, car3" + System.lineSeparator();
        assertEquals(expectedOutput, outputStream.toString());
    }

}