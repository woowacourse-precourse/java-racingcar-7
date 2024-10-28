package racingcar;

import java.util.List;
import java.util.stream.IntStream;

/**
 * The class {@code RacingGame} operates a racing game simulation. The game starts by receiving input from the user.
 * Once the race begins, it progresses automatically until the results are displayed.
 */
public class RacingGame {
    RacingInput racingInput = new RacingInput();
    RacingOutput racingOutput = new RacingOutput();
    List<Car> cars;
    int totalRounds;

    /**
     * Receiving input by {@link RacingInput#receiveCarNames()} and {@link RacingInput#receiveTotalRounds()}.
     */
    public void receiveInput() {
        cars = Car.from(racingInput.receiveCarNames());
        totalRounds = racingInput.receiveTotalRounds();
    }

    /**
     * A race progresses until the results are displayed.
     *
     * <p>In each round, all cars attempt to move forward, and the result is shown.
     * After all rounds are over, the winner of the game is announced. If there are multiple winners, they are announced
     * together.</p>
     */
    public void play() {
        System.out.println("\n실행 결과");
        IntStream.range(0, totalRounds).forEach(i -> doRound());

        racingOutput.displayWinner(calculateWinner());
    }

    private void doRound() {
        for (Car car : cars) {
            car.attemptMove();
        }

        List<CarDto> carDtos = cars.stream().map(Car::toDto).toList();
        racingOutput.displayRaceProgress(carDtos);
    }

    private List<String> calculateWinner() {
        List<CarDto> carDtos = cars.stream().map(Car::toDto).toList();
        int maxProgress = carDtos.stream()
                .map(CarDto::position)
                .max(Integer::compare)
                .orElseThrow(() -> new IllegalArgumentException("자동차가 입력되지 않았습니다."));

        return carDtos.stream()
                .filter(carDto -> carDto.position() == maxProgress)
                .map(CarDto::name)
                .toList();
    }
}
