package racingcar.service;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.Race;
import camp.nextstep.edu.missionutils.Randoms;

public class RacingCarService {

    private static final int MIN_RANDOM_NUMBER = 0;
    private static final int MAX_RANDOM_NUMBER = 9;

    public String raceStart(Race race) {

        StringBuilder raceResult = new StringBuilder();

        Integer round = race.getRound();
        List<Car> cars = race.getCars();

        for (int i = 0; i < round; i++) {
            raceResult.append(moveCars(cars));
        }

        return raceResult.toString();
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

    public Boolean isMove() {
        return Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER) >= 4;
    }
}
