package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RaceSystem {
    private static final int MAX_CAR_NAME_CONDITION = 5;
    private static final int MIN_RACE_TIME_CONDITION = 1;
    private static final int MIN_MOVE_CONDITION = 4;
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
                StringBuilder errorMessage = new StringBuilder();
                errorMessage.append("자동차 이름은 공백이거나 문자의 길이가 ");
                errorMessage.append(MAX_CAR_NAME_CONDITION);
                errorMessage.append(" 이상일 수 없습니다");
                throw new IllegalArgumentException(errorMessage.toString());
            }

            Car newCar = new Car(carName);
            carList.add(newCar);
        }

        return carList;
    }

    private int initializeRaceTime(int raceTime) {
        if (raceTime < MIN_RACE_TIME_CONDITION) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다");
        }

        return raceTime;
    }

    public String startRace() {
        StringBuilder result = new StringBuilder("실행 결과\n");

        for (int i = 0; i < raceTime; i++) {
            StringBuilder roundResult = startRound();
            result.append(roundResult);
            result.append('\n');
        }

        List<String> winners = findWinners();
        String raceResult = String.join(", ", winners);
        result.append("최종 우승자 : ");
        result.append(raceResult);

        return result.toString();
    }

    private StringBuilder startRound() {
        StringBuilder result = new StringBuilder();

        for (Car car: cars) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
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
