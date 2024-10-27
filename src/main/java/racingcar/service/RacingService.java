package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.constant.Constant;
import racingcar.domain.car.Car;
import racingcar.domain.car.CarName;
import racingcar.domain.car.Cars;
import racingcar.domain.car.Distance;
import racingcar.domain.race.Records;
import racingcar.domain.race.Result;
import racingcar.domain.race.RoundCount;

public class RacingService {

    public Result startRace(Cars cars, RoundCount roundCount) {
        List<Records> records = new ArrayList<>();
        for (int i = 1; i <= roundCount.getRoundCount(); i++) {
            records.add(startRound(cars));
        }
        return new Result(records);
    }

    private Records startRound(Cars cars) {
        Records records = new Records();
        for (Car car : cars.getCars()) {
            moveOrStop(car);
            records.addRecord(new CarName(car.getName()), new Distance(car.getDistance()));
        }
        return records;
    }

    private void moveOrStop(Car car) {
        int randomNumber = generateRandomNumber();
        if (randomNumber >= Constant.CAR_MOVE_CRITERIA) {
            car.moveForward();
        }
    }

    private int generateRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
