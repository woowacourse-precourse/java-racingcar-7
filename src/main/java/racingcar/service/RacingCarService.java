package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.Race;

public class RacingCarService {

    public Race createRace(String carNamesInput) {
        List<Car> cars = separateCarNames(carNamesInput);

        return new Race(cars);
    }

    private List<Car> separateCarNames(String carNamesInput) {
        List<Car> cars = new ArrayList<>();
        String[] carNames = carNamesInput.split(",");

        for (String name : carNames) {
            cars.add(new Car(name.trim()));
        }

        return cars;
    }

    protected void updateLocation(List<Car> cars) {
        for (Car car : cars) {
            int randomNumber = getRandomNumber();

            if (randomNumber >= 4) {
                car.move();
            }
        }
    }

    protected int getRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public List<Car> determineWinners(List<Car> cars) {
        List<Car> winners = new ArrayList<>();
        winners.add(cars.get(0));
        return winners;
    }
}
