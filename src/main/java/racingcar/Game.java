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
        String[] carNames = InputHandler.getCarNames();
        Validator.validateCarNames(carNames);

        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    private void inputAttempts() {
        attempts = InputHandler.getAttempts();

        Validator.validateAttempts(attempts);
    }

    private void runRace() {
        Race race = new Race(cars, attempts);
        race.start();
    }

    private void printWinners() {
        final List<String> winners = getWinners();
        String winnerNames = String.join(", ", winners);
        System.out.println("최종 우승자 : " + winnerNames);
    }

    private List<String> getWinners() {
        int maxPosition = getMaxPosition();

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .toList();
    }

    private int getMaxPosition() {
        return cars.stream()
                .max(Comparator.comparingInt(Car::getPosition))
                .orElseThrow(() -> new IllegalArgumentException("경주에 참가한 자동차가 없습니다."))
                .getPosition();
    }
}
