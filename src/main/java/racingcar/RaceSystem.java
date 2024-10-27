package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RaceSystem {
    private static final int MIN_MOVE_CONDITION = 4;
    private List<Car> cars;
    private int raceTime;

    public RaceSystem(List<String> carNames, int raceTime) {
        this.cars = new ArrayList<>();
        for (String carName: carNames) {
            Car newCar = new Car(carName);
            cars.add(newCar);
        }
        this.raceTime = raceTime;
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
            if(car.getDistance() == maxDistance) {
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
