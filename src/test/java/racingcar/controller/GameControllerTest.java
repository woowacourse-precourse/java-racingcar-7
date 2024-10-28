package racingcar.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.extractor.CarNameExtractor;
import racingcar.factory.CarFactory;
import racingcar.model.Car;
import racingcar.model.CarManager;
import racingcar.model.Race;
import racingcar.validator.CarNameValidator;
import racingcar.validator.RaceRoundsValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

class GameControllerTest {

    private InputView inputView;
    private RaceRoundsValidator raceRoundsValidator;
    private CarManager carManager;
    private OutputView outputView;
    private StringBuilder outputBuilder;

    @BeforeEach
    void setUp() {
        outputBuilder = new StringBuilder();
        inputView = new InputView() {
            @Override
            public String inputCarNames() {
                return "car1,car2,car3";
            }

            @Override
            public String inputRaceRounds() {
                return "3";
            }
        };
        raceRoundsValidator = new RaceRoundsValidator();
        carManager = new CarManager(new CarNameValidator(), new CarNameExtractor(), new CarFactory());
        outputView = new OutputView() {
            @Override
            public void printRoundResultsHeader() {
                outputBuilder.append("실행 결과\n");
            }

            @Override
            public void printRoundResults(List<Car> cars) {
                for (Car car : cars) {
                    outputBuilder.append(car.getName()).append(" : ").append("-".repeat(car.getDistance()))
                            .append("\n");
                }
                outputBuilder.append("\n");
            }

            @Override
            public void printWinner(String winners) {
                outputBuilder.append("최종 우승자 : ").append(winners).append("\n");
            }
        };
    }

    @AfterEach
    void tearDown() {
        outputBuilder.setLength(0);
    }

    @Test
    void startGame_ValidInput_ProcessesRace() {
        GameController gameController = new GameController(inputView, raceRoundsValidator, carManager, outputView);

        gameController.startGame();

        Race race = gameController.getRace();
        List<String> winners = race.getWinners(race.getParticipatingCars());

        outputView.printRoundResults(race.getParticipatingCars());
        String expectedOutput = "실행 결과\n";
        assertThat(outputBuilder.toString()).contains(expectedOutput);

        outputView.printWinner(String.join(", ", winners));
        String expectedOutput2 = "최종 우승자 : ";
        assertThat(outputBuilder.toString()).contains(expectedOutput2);
    }
}
