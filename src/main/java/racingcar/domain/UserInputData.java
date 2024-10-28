package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.dto.RacingResult;
import racingcar.view.OutputView;

public class UserInputData {
    private final List<Car> cars;
    private final int tryCount;

    public List<Car> getCars() {
        return cars;
    }

    public UserInputData(List<Car> cars, int tryCount) {
        this.cars = cars;
        this.tryCount = tryCount;
    }

    public RacingResult startRacing() {
        for (int i = 0; i < tryCount; i++) {
            cars.stream()
                    .forEach(car -> {car.moveRandomly(if60PercentChance());});
        }
        RacingResult racingResults = getRacingResults();

        return racingResults;
    }

    public RacingResult getRacingResults() {
        return new RacingResult(getCars(), getWinners());
    }

    public List<String> getWinners() {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        List<String> winners = new ArrayList<>();
        cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .forEach(winners::add);

        return winners;
    }

    private static boolean if60PercentChance() {
        int pickNumberInRange = Randoms.pickNumberInRange(0, 9);
        if (pickNumberInRange >= 4) {
            return true;
        }
        return false;
    }
}
