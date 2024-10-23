package service;

import camp.nextstep.edu.missionutils.Randoms;
import constant.Race;
import domain.Car;
import domain.Cars;
import java.util.List;
import view.OutputView;

public class RacingService {

    public void moveCars(Cars cars) {
        for (Car car : cars.getCarsList()) {
            int randomNumber = getRandomNumber();
            if (randomNumber >= Race.MOVE_THRESHOLD.getValue()) {
                car.addScore();
            }
        }
    }

    private int getRandomNumber() {
        return Randoms.pickNumberInRange(Race.MIN_RANDOM_VALUE.getValue(), Race.MAX_RANDOM_VALUE.getValue());
    }

    public void getWinners(Cars cars) {
        int maxScore = cars.getCarsList().stream()
                .mapToInt(Car::getScore)
                .max()
                .orElse(0);

        List<String> winners = cars.getCarsList().stream()
                .filter(car -> car.getScore() == maxScore)
                .map(Car::getName)
                .toList();

        OutputView.showWinners(winners);
    }
}
