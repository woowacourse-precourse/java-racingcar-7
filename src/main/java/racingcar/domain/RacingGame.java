package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.*;
import java.util.stream.Collectors;

public class RacingGame {
    private static final int MOVE_FORWARD_CRITERION = 4;  // 전진 기준값 수정
    private final List<Car> cars;
    private final int totalRounds;
    private int currentRound;

    public RacingGame(String[] carNames, int rounds) {
        validateInputs(carNames, rounds);
        this.cars = createCars(carNames);
        this.totalRounds = rounds;
        this.currentRound = 0;
    }

    private void validateInputs(String[] carNames, int rounds) {
        if (carNames == null || carNames.length == 0) {
            throw new IllegalArgumentException("자동차가 없습니다.");
        }
        validateCarNames(carNames);
        if (rounds <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }
    }

    private void validateCarNames(String[] carNames) {
        List<String> trimmedNames = Arrays.stream(carNames)
                .map(String::trim)
                .collect(Collectors.toList());

        if (trimmedNames.stream().anyMatch(String::isEmpty)) {
            throw new IllegalArgumentException("자동차 이름은 비어있을 수 없습니다.");
        }

        Set<String> uniqueNames = new HashSet<>(trimmedNames);
        if (uniqueNames.size() != carNames.length) {
            throw new IllegalArgumentException("중복된 자동차 이름이 있습니다.");
        }
    }

    private List<Car> createCars(String[] carNames) {
        return Arrays.stream(carNames)
                .map(String::trim)
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public void playOneRound() {
        if (isGameFinished()) {
            return;
        }

        cars.forEach(car -> {
            int number = Randoms.pickNumberInRange(0, 9);
            if (number >= MOVE_FORWARD_CRITERION) {
                car.move();
            }
        });
        currentRound++;
    }

    public boolean isGameFinished() {
        return currentRound >= totalRounds;
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public List<String> getWinners() {
        int maxPosition = findMaxPosition();
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private int findMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }
}
