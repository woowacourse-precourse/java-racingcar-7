package racingcar.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.CarMover;
import racingcar.view.CarNameInputValidator;
import racingcar.view.MoveCountInputValidator;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RacingCarControllerTest {
    private RacingCarController controller;
    private CarMover carMover;

    @BeforeEach
    void setUp() {
        carMover = new CarMover();
        controller = new RacingCarController(new CarNameInputValidator(), new MoveCountInputValidator(), carMover);
    }

    @DisplayName("자동차 이동 결과 출력")
    @Test
    void printResults() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        controller.createCars(List.of("car1", "car2"));

        Car car1 = controller.getCars().get(0);
        Car car2 = controller.getCars().get(1);

        carMover.move(car1, 5);
        carMover.move(car1, 8);
        carMover.move(car2, 5);
        carMover.move(car2, 3);

        controller.printResults();

        String outputString = outContent.toString().trim();
        assertTrue(outputString.contains("car1 : --"));
        assertTrue(outputString.contains("car2 : -"));
    }

    @DisplayName("최종 우승자 확인")
    @Test
    void determineWinners() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        controller.createCars(List.of("car1", "car2", "car3"));

        Car car1 = controller.getCars().get(0);
        Car car2 = controller.getCars().get(1);
        Car car3 = controller.getCars().get(2);

        carMover.move(car1, 5);
        carMover.move(car2, 5);
        carMover.move(car3, 3);

        controller.printResults();
        controller.printWinners();

        String expectedWinnersOutput = "최종 우승자 : car1, car2";
        assertThat(outContent.toString().trim()).contains(expectedWinnersOutput);
    }
}
