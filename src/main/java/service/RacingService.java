package service;

import camp.nextstep.edu.missionutils.Randoms;
import domain.Car;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import view.OutputView;

public class RacingService {
    public List<Car> getCarsList(String input) {
        String[] names = input.split(",");

        List<Car> carsList = new ArrayList<>();
        for (String name : names) {
            carsList.add(new Car(name));
        }

        return carsList;
    }


    public void moveCars(List<Car> carsList) {
        for (Car car : carsList) {
            int randomNumber = getRandomNumber();
            if (randomNumber >= 4) {
                car.addScore();
            }
        }
    }

    private int getRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public void getWinners(List<Car> carsList) {
        int maxScore = carsList.stream()
                .mapToInt(Car::getScore)
                .max()
                .orElse(0);

        List<String> winners = carsList.stream()
                .filter(car -> car.getScore() == maxScore)
                .map(Car::getName)
                .toList();

        OutputView.showWinners(winners);
    }
}
