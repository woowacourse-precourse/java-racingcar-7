package racingcar.io.output.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.CarCollection;
import racingcar.domain.CarName;

class OutputConsoleTest {
    private final OutputConsole outputConsole = new OutputConsole();

    @AfterEach
    void closeConsole() {
        Console.close();
    }

    @Test
    void 사용자에게_실행_결과_메시지를_출력한다() {
        OutputStream output = createOutputStream();
        System.setOut(new PrintStream(output));

        outputConsole.printStartMessage();

        String expectedOutput = "\n실행 결과" + System.lineSeparator();
        assertThat(output.toString()).isEqualTo(expectedOutput);
    }

    @Test
    void 사용자에게_라운드별_자동차_상태를_출력한다() {
        Car car1 = new Car(new CarName("pobi"));
        Car car2 = new Car(new CarName("woni"));
        car1.move(4);
        CarCollection cars = new CarCollection(Arrays.asList(car1, car2));
        OutputStream output = createOutputStream();
        System.setOut(new PrintStream(output));

        outputConsole.printRoundResult(cars);

        String expectedOutput =
                "pobi : -" + System.lineSeparator() + "woni : " + System.lineSeparator() + System.lineSeparator();
        assertThat(output.toString()).isEqualTo(expectedOutput);
    }

    @Test
    void 사용자에게_최종_우승자를_출력한다() {
        Car car1 = new Car(new CarName("pobi"));
        Car car2 = new Car(new CarName("woni"));
        car1.move(4); // car1이 우승 포지션에 도달하도록 설정
        CarCollection cars = new CarCollection(Arrays.asList(car1, car2));
        OutputStream output = createOutputStream();
        System.setOut(new PrintStream(output));

        outputConsole.printWinners(cars);

        String expectedOutput = "최종 우승자 : pobi" + System.lineSeparator();
        assertThat(output.toString()).isEqualTo(expectedOutput);
    }

    private OutputStream createOutputStream() {
        return new ByteArrayOutputStream();
    }

    @Test
    void close메서드가_호출된_후_Console을_사용할_수_없다() {
        outputConsole.close();

        assertThatThrownBy(() -> Console.readLine())
                .isInstanceOf(NoSuchElementException.class)
                .hasMessageContaining("No line found");
    }
}
