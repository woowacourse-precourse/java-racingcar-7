package racingcar.iohandler;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Car;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class OutputHandlerTest {

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final OutputHandler outputHandler = new OutputHandler();

    @AfterEach
    void tearDown() {
        Console.close();
    }

    @DisplayName("차량과 점수가 주어지면 해당 진행 상태를 출력한다.")
    @Test
    void showCarProceedScore() {
        System.setOut(new PrintStream(outputStream));
        Car car = Car.createCar("apple");
        int proceedScore = 3;

        outputHandler.showCarProceedScore(car, proceedScore);

        String expectedOutput = "apple : ---";
        assertThat(outputStream.toString().trim()).isEqualTo(expectedOutput);
    }

    @DisplayName("우승자가 한명 결정되면, 우승자 안내 문구를 출력한다.")
    @Test
    void showWinnersWithOne() {
        System.setOut(new PrintStream(outputStream));
        List<String> winners = new ArrayList<>();
        winners.add("apple");

        outputHandler.showWinners(winners);

        String expectedOutput = "최종 우승자 : apple";
        assertThat(outputStream.toString().trim()).isEqualTo(expectedOutput);

    }

    @DisplayName("우승자가 한명 결정되면, 우승자 안내 문구를 출력한다.")
    @Test
    void showWinnersWithTwo() {
        System.setOut(new PrintStream(outputStream));
        List<String> winners = new ArrayList<>();
        winners.add("apple");
        winners.add("lemon");

        outputHandler.showWinners(winners);

        String expectedOutput = "최종 우승자 : apple, lemon";
        assertThat(outputStream.toString().trim()).isEqualTo(expectedOutput);

    }
}