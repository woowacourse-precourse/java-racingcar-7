package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.constant.Constant;
import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;
import racingcar.domain.race.Record;
import racingcar.domain.race.Result;
import racingcar.domain.race.Results;

public class RacingService {

    public Results startRace(Cars cars, int roundCount) {
        List<Result> results = new ArrayList<>();
        for (int round = 1; round <= roundCount; round++) {
            Result result = new Result(round);
            startRound(cars, result);
            results.add(result);
        }
        return new Results(results);
    }

    private void startRound(Cars cars, Result result) {
        List<Car> raceCars = cars.getCars();
        for (Car car : raceCars) {
            moveOrStop(car);
            Record record = new Record(car.getName(), car.getDistance());
            result.addRecord(record);
        }
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
