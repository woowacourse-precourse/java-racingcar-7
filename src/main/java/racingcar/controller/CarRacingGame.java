package racingcar.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.RaceRecord;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.Map;
import racingcar.view.OutputHandler;

public class CarRacingGame implements Game {
    private static final int MOVE_DISTANCE = 1;
    private static final int RANGE_MIN = 0;
    private static final int RANGE_MAX = 9;
    private static final int MOVE_THRESHOLD = 4;
    RaceRecord raceRecord;
    int moveAttemptCount;

    public CarRacingGame(List<String> carNames, int moveAttemptCount) {
        this.moveAttemptCount = moveAttemptCount;
        this.raceRecord = new RaceRecord(carNames);
    }

    public void start() {
        for (int count = 0; count < moveAttemptCount; count++) {
            attemptMoveAllCar();
            OutputHandler.printAllCarDistances(raceRecord);
            System.out.println();
        }
        List<Car> winners = findWinners();
        OutputHandler.printWinner(winners);
    }

    private void attemptMoveSingleCar(Car car) {
        if (isMoveAble()) {
            moveForward(car);
        }
    }

    private boolean isMoveAble() {
        return Randoms.pickNumberInRange(RANGE_MIN, RANGE_MAX) >= MOVE_THRESHOLD;
    }

    private void moveForward(Car car) {
        raceRecord.updateCarRecord(car, MOVE_DISTANCE);
    }

    private void attemptMoveAllCar() {
        Map<Car, Integer> allCarRecord = raceRecord.getRaceResult();

        for (Car car : allCarRecord.keySet()) {
            attemptMoveSingleCar(car);
        }
    }

    private List<Car> findWinners() {
        Map<Car, Integer> allCars = raceRecord.getRaceResult();
        List<Car> winner = new ArrayList<>();
        int max_distance = Collections.max(allCars.values());

        for (Map.Entry<Car, Integer> car : allCars.entrySet()) {
            if (car.getValue() == max_distance) {
                winner.add(car.getKey());
            }
        }
        return winner;
    }
}