package racingcar.model;

import racingcar.utils.InputHandler;
import racingcar.utils.OutputHandler;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private List<Car> cars;
    private int attempts;
    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;

    private static final String INPUT_CARS_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_ATTEMPTS_MESSAGE = "시도할 횟수는 몇 회인가요?";
    private static final String INVALID_CAR_NAME_MESSAGE = "자동차 이름은 하나 이상 입력해야 합니다.";
    private static final String CAR_NAME_LENGTH_MESSAGE = "자동차 이름은 1자 이상 5자 이하만 가능합니다.";
    private static final String START_MESSAGE = "실행 결과";
    private static final String WINNERS_MESSAGE = "최종 우승자 : ";

    public RacingGame() {
        this.inputHandler = new InputHandler();
        this.outputHandler = new OutputHandler();
    }

    public void run() {
        inputCars();
        inputAttempts();
        startRace();
        printWinners();
    }

    private void inputCars() {
        String[] names = inputHandler.inputNames(INPUT_CARS_MESSAGE);
        validateCarNames(names);
        cars = Arrays.stream(names)
                .map(Car::new)
                .collect(Collectors.toList());
    }

    private void inputAttempts() {
        attempts = inputHandler.inputNumber(INPUT_ATTEMPTS_MESSAGE);
    }

    private void startRace() {
        outputHandler.printMessage(START_MESSAGE);
        for (int i = 0; i < attempts; i++) {
            raceOnce();
            for (Car car : cars) {
                outputHandler.printProgress(car.getName(), "-".repeat(car.getPosition()));
            }
        }
    }

    private void raceOnce() {
        for (Car car : cars) {
            car.move();
        }
    }

    private void printWinners() {
        int maxPosition = cars.stream().mapToInt(Car::getPosition).max().orElse(0);
        List<String> winners = cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
        outputHandler.printMessage(WINNERS_MESSAGE + String.join(", ", winners));
    }

    private void validateCarNames(String[] names) {
        if (names.length == 0) {
            throw new IllegalArgumentException(INVALID_CAR_NAME_MESSAGE);
        }
        for (String name : names) {
            if (name.length() > 5 || name.isEmpty()) {
                throw new IllegalArgumentException(CAR_NAME_LENGTH_MESSAGE);
            }
        }
    }
}
