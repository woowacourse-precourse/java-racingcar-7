package racingcar.Service;

import racingcar.Model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    public static final String INVALID_ATTEMPT_COUNT_MESSAGE = "시도할 횟수는 1 이상의 숫자여야 합니다.";

    private final List<Car> raceCars;
    private final int numberOfAttempts;

    public RacingGame(List<Car> raceCars, int numberOfAttempts) {
        validateAttempts(numberOfAttempts);
        this.raceCars = new ArrayList<>(raceCars);
        this.numberOfAttempts = numberOfAttempts;
    }

    public void startRace() {
        playRounds();
        announceWinners();
    }

    private void playRounds() {
        for (int round = 0; round < numberOfAttempts; round++) {
            playSingleRound();
        }
    }

    private void playSingleRound() {
        raceCars.replaceAll(Car::move);
        displayRoundResults();
    }

    private void displayRoundResults() {
        raceCars.forEach(car -> System.out.println(car.displayPosition()));
        System.out.println();
    }

    private void announceWinners() {
        int maxPosition = findMaxPosition();
        List<String> winners = raceCars.stream()
                .filter(car -> car.getCurrentPosition() == maxPosition)
                .map(Car::getCarName)
                .collect(Collectors.toList());

        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }

    private int findMaxPosition() {
        return raceCars.stream()
                .mapToInt(Car::getCurrentPosition)
                .max()
                .orElseThrow(() -> new IllegalStateException("경주에 참여한 자동차가 없습니다."));
    }

    private void validateAttempts(int attempts) {
        if (attempts < 1) {
            throw new IllegalArgumentException(INVALID_ATTEMPT_COUNT_MESSAGE);
        }
    }
}
