package racingcar.domain.race;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;
import racingcar.dto.RaceProgressDto;
import racingcar.dto.RaceResultDto;
import racingcar.view.OutputView;

public class Race {
    private static final int MOVE_THRESHOLD = 4;
    private static final int RANDOM_LOWER_BOUND = 0;
    private static final int RANDOM_UPPER_BOUND = 9;

    private final Cars cars;
    private final int tryCount;

    private Race(final Cars cars, final int tryCount) {
        this.cars = cars;
        this.tryCount = tryCount;
    }

    public static Race from(final Cars cars, final int tryCount) {
        return new Race(cars, tryCount);
    }

    public void start() {
        for (int i = 0; i < this.tryCount; i++) {
            progress();
            displayProgress();
        }
        displayResult();
    }

    private void progress() {
        OutputView.showResultMessage();
        this.cars.getCars().forEach(this::moveCarIfPossible);
    }

    private void moveCarIfPossible(Car car) {
        int randomNum = Randoms.pickNumberInRange(RANDOM_LOWER_BOUND, RANDOM_UPPER_BOUND);
        if (randomNum >= MOVE_THRESHOLD) {
            car.move();
        }
    }

    private void displayProgress() {
        RaceProgressDto raceProgressDto = RaceProgressDto.from(this.cars);
        OutputView.showRaceProgress(raceProgressDto);
    }

    private void displayResult() {
        List<Car> winners = determineWinners();
        RaceResultDto raceResultDto = RaceResultDto.from(winners);
        OutputView.showRaceResult(raceResultDto);
    }

    private List<Car> determineWinners() {
        int maxPosition = this.cars.getCars().stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        return this.cars.getCars().stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }
}

