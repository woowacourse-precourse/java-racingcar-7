package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static racingcar.constants.RaceSystemConstant.*;
import static racingcar.constants.ErrorMessage.CAR_NAME_LENGTH_ERROR_MESSAGE;
import static racingcar.constants.ErrorMessage.RACE_TIME_RANGE_ERROR_MESSAGE;
import static racingcar.constants.SystemMessage.RACE_WINNERS_MESSAGE;
import static racingcar.constants.SystemMessage.START_RACE_MESSAGE;

public class RaceSystem {

    private List<Car> cars;
    private int raceTime;

    public RaceSystem(List<String> carNames, int raceTime) {
        this.cars = initializeCars(carNames);
        this.raceTime = initializeRaceTime(raceTime);
    }
    
    private List<Car> initializeCars(List<String> carNames) {
        List<Car> carList = new ArrayList<>();

        for (String carName: carNames) {
            if (carName.isBlank() || carName.length() > MAX_CAR_NAME_CONDITION) {
                throw new IllegalArgumentException(CAR_NAME_LENGTH_ERROR_MESSAGE);
            }

            Car newCar = new Car(carName);
            carList.add(newCar);
        }

        return carList;
    }

    private int initializeRaceTime(int raceTime) {
        if (raceTime < MIN_RACE_TIME_CONDITION) {
            throw new IllegalArgumentException(RACE_TIME_RANGE_ERROR_MESSAGE);
        }

        return raceTime;
    }

    public String startRace() {
        StringBuilder result = new StringBuilder(START_RACE_MESSAGE);

        for (int i = 0; i < raceTime; i++) {
            StringBuilder roundResult = startRound();
            result.append(roundResult);
            result.append('\n');
        }

        List<String> winners = findWinners();
        String raceResult = String.join(", ", winners);
        result.append(RACE_WINNERS_MESSAGE);
        result.append(raceResult);

        return result.toString();
    }

    private StringBuilder startRound() {
        StringBuilder result = new StringBuilder();

        for (Car car: cars) {
            int randomNumber = Randoms.pickNumberInRange(RANDOM_NUMBER_LOWER_BOUND, RANDOM_NUMBER_UPPER_BOUND);
            if (randomNumber >= MIN_MOVE_CONDITION) {
                car.move();
            }

            StringBuilder carStatus = getCarStatus(car);
            result.append(carStatus);
        }

        return result;
    }

    private StringBuilder getCarStatus(Car car) {
        String distance = "-".repeat(car.getDistance());

        StringBuilder result = new StringBuilder();
        result.append(car.getName());
        result.append(" : ");
        result.append(distance);
        result.append('\n');

        return result;
    }

    private List<String> findWinners() {
        List<String> winners = new ArrayList<>();
        int maxDistance = findMaxDistance();

        for (Car car: cars) {
            if (car.getDistance() == maxDistance) {
                winners.add(car.getName());
            }
        }

        return winners;
    }

    private int findMaxDistance() {
        int maxDistance = Integer.MIN_VALUE;

        for (Car car: cars) {
            maxDistance = Integer.max(maxDistance, car.getDistance());
        }

        return maxDistance;
    }
}
