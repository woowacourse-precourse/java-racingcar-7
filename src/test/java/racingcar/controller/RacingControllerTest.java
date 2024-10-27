package racingcar.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.car.Car;
import racingcar.input.InputManager;
import racingcar.output.OutputManager;

class RacingControllerTest {

    private RacingController racingController;
    private TestInputManager inputManager;
    private TestOutputManager outputManager;

    @BeforeEach
    void 경주_컨트롤러를_생성한다() {
        inputManager = new TestInputManager();
        outputManager = new TestOutputManager();
        racingController = new RacingController(inputManager, outputManager);
    }

    @Test
    void 경주_자동차_목록을_설정한다() throws NoSuchFieldException, IllegalAccessException {
        // when
        racingController.setupGame();

        // then
        List<Car> cars = getCarsFromController();
        assertThat(cars).hasSize(3);
        assertThat(cars.get(0).getName()).isEqualTo("car1");
        assertThat(cars.get(1).getName()).isEqualTo("car2");
        assertThat(cars.get(2).getName()).isEqualTo("car3");
    }

    @Test
    void 시도_횟수에_따라_경주를_진행한다() {
        // given
        inputManager.setAttemptCount(3);
        racingController.setupGame();

        // when
        racingController.startRace();

        // then
        assertThat(outputManager.positionLogs).hasSize(3);
    }

    @Test
    void 경주_우승자를_출력한다() {
        // given
        inputManager.setAttemptCount(1);
        racingController.setupGame();
        racingController.startRace();

        // when
        racingController.displayWinners();

        // then
        assertThat(outputManager.winnerLog).contains("최종 우승자");
    }

    private List<Car> getCarsFromController() throws NoSuchFieldException, IllegalAccessException {
        Field carsField = RacingController.class.getDeclaredField("cars");
        carsField.setAccessible(true);
        return (List<Car>) carsField.get(racingController);
    }

    private static class TestInputManager implements InputManager {

        private long attemptCount;

        @Override
        public List<Car> getCars() {
            return List.of(new Car("car1"), new Car("car2"), new Car("car3"));
        }

        @Override
        public long getAttemptCount() {
            return attemptCount;
        }

        public void setAttemptCount(long count) {
            this.attemptCount = count;
        }
    }

    private static class TestOutputManager implements OutputManager {

        private final List<String> positionLogs = new ArrayList<>();
        private String winnerLog;

        @Override
        public void displayPosition(List<Car> cars) {
            StringBuilder log = new StringBuilder();
            for (Car car : cars) {
                String positionIndicator = "-".repeat(car.getPosition());
                log.append(car.getName())
                        .append(" : ")
                        .append(positionIndicator)
                        .append("\n");
            }
            positionLogs.add(log.toString().trim());
        }

        @Override
        public void displayWinners(List<Car> winners) {
            winnerLog = "최종 우승자 : " +
                    winners.stream()
                            .map(Car::getName)
                            .reduce((a, b) -> a + ", " + b)
                            .orElse("");
        }

        @Override
        public void displayError(String message) {
            // do nothing
        }
    }
}
