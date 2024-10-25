package racingcar;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 게임의 전체 흐름을 관리 (입력, 레이스 실행, 결과 출력)
 */
public class Game {
    private final List<Car> cars = new ArrayList<>();
    private int attempts;

    public void start() {
        inputCarNames();
        inputAttempts();
        runRace();
        printWinners();
    }

    private void inputCarNames() {
        OutputHandler.printStartMessage();

        String[] carNames = InputHandler.getCarNames();

        Validator.validateCarNames(carNames);

        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    private void inputAttempts() {
        OutputHandler.printAttemptsMessage();

        attempts = InputHandler.getAttempts();

        Validator.validateAttempts(attempts);
    }

    private void runRace() {
        OutputHandler.printRaceResultHeader();

        Race race = new Race(cars, attempts);
        race.start();
    }

    private void printWinners() {
        final List<String> winners = getWinners();

        OutputHandler.printWinners(winners);
    }

    /**
     * @return maxPosition과 같은 값을 가지는 자동차 이름 List
     */
    private List<String> getWinners() {
        int maxPosition = getMaxPosition();

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .toList();
    }

    /**
     * @return 각각 자동차 중 최대 position 값 (= 최종 우승자의 position 값)
     */
    private int getMaxPosition() {
        return cars.stream()
                .max(Comparator.comparingInt(Car::getPosition))
                .orElseThrow(() -> new IllegalArgumentException("경주에 참가한 자동차가 없습니다."))
                .getPosition();
    }
}
