package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.constant.Constant;
import racingcar.domain.Car;
import racingcar.domain.Record;
import racingcar.domain.Result;

public class RacingService {

    public List<Result> startRace(List<Car> cars, int roundCount) {
        List<Result> results = new ArrayList<>();
        for (int i = 1; i <= roundCount; i++) {
            Result result = new Result(i);
            startRound(cars, result);
            results.add(result);
        }
        return results;
    }

    private void startRound(List<Car> cars, Result result) {
        for (Car car : cars) {
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
