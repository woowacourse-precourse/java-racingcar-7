package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Car;
import racingcar.model.Race;
import racingcar.util.Constant;

import java.util.List;
import java.util.stream.Collectors;

public class GameService {

    public void playRound(Race race) {
        for (Car car : race.getCarList()) {
            move(car, getRandomNumber());
        }
    }

    public List<Car> getFinalWinners(Race race) {
        List<Car> carList = race.getCarList();

        int maxCurrentRound = getMaxCurrentRound(carList);

        return carList.stream()
                .filter(car -> car.getCurrentLocation() == maxCurrentRound)
                .collect(Collectors.toList());
    }

    private int getRandomNumber() {
        return Randoms.pickNumberInRange(Constant.MIN_RANDOM_VALUE, Constant.MAX_RANDOM_VALUE);
    }

    void move(Car car, int randomNumber) {
        if (randomNumber >= Constant.THRESHOLD_VALUE) {
            car.increaseCurrentLocation();
        }
    }

    private int getMaxCurrentRound(List<Car> carList) {
        return carList.stream()
                .mapToInt(Car::getCurrentLocation)
                .max()
                .orElse(-1);
    }

}
