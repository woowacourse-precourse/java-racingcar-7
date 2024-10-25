package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import racingcar.model.Car;
import racingcar.model.RandomRange;

public class RaceService {

    public void race(List<Car> cars) {
        for (Car car : cars) {
            int randomNumber = Randoms.pickNumberInRange(RandomRange.MIN.getNumber(), RandomRange.MAX.getNumber());
            move(car, randomNumber);
        }
    }

    public static void move(Car car, int randomNumber) {
        if (randomNumber >= 4) {
            int currentProgress = car.getProgress();
            car.setProgress(currentProgress + 1);
        }
    }

    public void findWinner(List<Car> cars, List<String> winner) {
        int maxValue = findMaxValue(cars);
        for (Car car : cars) {
            if (car.getProgress() == maxValue) {
                winner.add(car.getName());
            }
        }
    }

    private int findMaxValue(List<Car> progress) {
        return progress.stream().max(Comparator.comparingInt(Car::getProgress))
                .orElseThrow(NoSuchElementException::new)
                .getProgress();
    }
}
