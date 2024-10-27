package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.Race;
import camp.nextstep.edu.missionutils.Randoms;

public class RacingCarService {

    private static final int MIN_RANDOM_NUMBER = 0;
    private static final int MAX_RANDOM_NUMBER = 9;

    public String raceStart(Race race) {

        StringBuilder roundResult = new StringBuilder();

        Integer round = race.getRound();
        List<Car> cars = race.getCars();

        for (int i = 0; i < round; i++) {
            roundResult.append(moveCars(cars));
            if (i != round - 1) {
                roundResult.append("\n");
            }
        }

        return roundResult.toString();
    }

    public String moveCars(List<Car> cars) {

        StringBuilder roundResult = new StringBuilder();

        for (Car car : cars) {
            if (isMove()) {
                car.move();
            }
            roundResult.append(car.printPosition()).append("\n");
        }

        return roundResult.toString();
    }

    public String findWinner(Race race) {

        List<Car> cars = race.getCars();
        int maxPosition = getMaxPosition(cars);
        List<String> winners = new ArrayList<>();

        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }

        return String.join(", ", winners);
    }

    public Integer getMaxPosition(List<Car> cars) {

        int maxPosition = 0;

        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }

        return maxPosition;
    }

    public Boolean isMove() {
        return Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER) >= 4;
    }
}
