package racingcar;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingGame {
    RacingInput racingInput = new RacingInput();
    List<Car> cars;
    int totalRounds;

    public void receiveInput() {
        cars = Car.from(racingInput.receiveCarNames());
        totalRounds = racingInput.receiveTotalRounds();
    }

    public void play() {
        System.out.println("\n실행 결과");
        IntStream.range(0, totalRounds).forEach(i -> doRound());
        displayWinner();
    }

    private void doRound() {
        for (Car car : cars) {
            car.attemptMove();
        }
        displayRaceProgress();
    }

    private void displayRaceProgress() {
        String raceProgress = cars.stream()
                .map(Car::toString)
                .collect(Collectors.joining());
        System.out.println(raceProgress);
    }

    private void displayWinner() {
        int maxProgress = cars.stream()
                .map(Car::getPosition)
                .max(Integer::compare)
                .orElseThrow(() -> new IllegalArgumentException("자동차가 입력되지 않았습니다."));
        String winners = cars.stream()
                .filter(car -> car.getPosition() == maxProgress)
                .map(Car::getName)
                .collect(Collectors.joining(", "));
        System.out.println("최종 우승자 : " + winners);
    }
}
