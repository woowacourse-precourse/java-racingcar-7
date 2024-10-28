package racingcar.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;
import racingcar.util.Parser;
import racingcar.util.CarValidator;
import racingcar.util.RaceValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RaceControllerTest {

    private RaceController raceController;

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        CarValidator carValidator = new CarValidator();
        RaceValidator raceValidator = new RaceValidator();
        Parser parser = new Parser();

        InputView inputView = new InputView(carValidator, raceValidator, parser) {
            @Override
            public List<String> getCarNames() {
                return Arrays.asList("CarA", "CarB", "CarC");
            }

            @Override
            public int getRaceCount() {
                return 5;
            }
        };

        OutputView outputView = new OutputView() {
            @Override
            public void printResult() {
                System.out.print("실행 결과\n");
            }

            @Override
            public void printCurrentPositions(List<Car> cars) {
                for (Car car : cars) {
                    System.out.printf("%s : %s\n", car.getName(), "-".repeat(car.getPosition()));
                }
            }

            @Override
            public void printWinners(List<Car> winners) {
                String winnerNames = String.join(", ", winners.stream().map(Car::getName).toArray(String[]::new));
                System.out.print("최종 우승자 : " + winnerNames + "\n");
            }
        };

        raceController = new RaceController(inputView, outputView);
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    @DisplayName("경주가 올바르게 진행되고 결과가 출력되는지 확인")
    void testStartRace() {
        // Act
        raceController.startRace();

        // Assert
        String output = outputStreamCaptor.toString().trim();
        assertThat(output).contains("실행 결과");
        assertThat(output).contains("CarA : ");
        assertThat(output).contains("CarB : ");
        assertThat(output).contains("CarC : ");
        assertThat(output).contains("최종 우승자 : ");
    }
}
