package racingcar.Service;

import racingcar.Model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private final List<Car> raceCars;
    private final int numberOfAttempts;

    public RacingGame(List<Car> raceCars, int numberOfAttempts) {
        validateCars(raceCars); // 자동차 유효성 검사
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
    private void validateCars(List<Car> raceCars) {
        if (raceCars.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 빈 문자열이거나 5자보다 길 수 없습니다.");
        }
    }
    private void announceWinners() {
        List<String> winners = getWinners();
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }

    private List<String> getWinners() {
        int maxPosition = findMaxPosition();
        return raceCars.stream()
                .filter(car -> car.getCurrentPosition() == maxPosition)
                .map(Car::getCarName)
                .collect(Collectors.toList());
    }

    private int findMaxPosition() {
        return raceCars.stream()
                .mapToInt(Car::getCurrentPosition)
                .max()
                .orElseThrow(() -> new IllegalStateException("경주에 참여한 자동차가 없습니다."));
    }
}