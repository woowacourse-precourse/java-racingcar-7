package racingcar;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.car.Car;
import racingcar.io.Output;

public class OutputTest {

    private ByteArrayOutputStream outputMessage;
    private final PrintStream standardOut = System.out;

    @BeforeEach
    void setUp() {
        outputMessage = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputMessage));
    }

    @AfterEach
    void setOut() {
        System.setOut(standardOut);
    }

    @Test
    void 메시지_출력_테스트() {
        String message = "test";
        Output.printMessage(message);
        Assertions.assertThat(outputMessage.toString().trim()).isEqualTo(message);
    }

    @Test
    void 결과_메시지_출력_테스트() {
        Output.printRoundResultMessage();
        Assertions.assertThat(outputMessage.toString().trim()).isEqualTo("실행 결과");
    }

    @Test
    void 라운드별_실행결과_출력_테스트() {
        Car bmw = new Car("bmw");
        Car audi = new Car("audi");
        List<Car> cars = Arrays.asList(bmw, audi);
        bmw.move(5);
        audi.move(3);

        Output.printRoundResult(cars);

        String result = """
                bmw : -
                audi : """;
        Assertions.assertThat(outputMessage.toString().trim()).isEqualTo(result);
    }

    @Test
    void 우승자_이름_출력_테스트() {
        List<String> winners = Arrays.asList("bmw", "audi");
        Output.printWinners(winners);
        Assertions.assertThat(outputMessage.toString().trim()).isEqualTo("최종 우승자 : bmw, audi");
    }

    @Test
    void 자동차_위치_라운드별_결과_출력_테스트() {
        Car bmw = new Car("bmw");
        Car audi = new Car("audi");
        Car tesla = new Car("tesla");
        List<Car> cars = Arrays.asList(bmw, audi, tesla);
        bmw.move(5);
        bmw.move(1);
        bmw.move(3);
        audi.move(5);
        audi.move(4);
        audi.move(3);
        tesla.move(9);
        tesla.move(5);
        tesla.move(7);

        Output.printRoundResult(cars);

        String result = """
                bmw : -
                audi : --
                tesla : ---""";
        Assertions.assertThat(outputMessage.toString().trim()).isEqualTo(result);
    }
}
