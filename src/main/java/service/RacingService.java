package service;

import camp.nextstep.edu.missionutils.Randoms;
import domain.Car;
import domain.Cars;
import java.util.List;
import view.OutputView;

public class RacingService {



    public void moveCars(Cars carsList) {
        for (Car car : carsList.getCarsList()) {
            int randomNumber = getRandomNumber();
            if (randomNumber >= 4) {
                car.addScore();
            }
        }
    }

    private int getRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public void getWinners(Cars carsList) {
        int maxScore = carsList.getCarsList().stream()
                .mapToInt(Car::getScore)
                .max()
                .orElse(0);

        List<String> winners = carsList.getCarsList().stream()
                .filter(car -> car.getScore() == maxScore)
                .map(Car::getName)
                .toList();

        OutputView.showWinners(winners);
    }
}
