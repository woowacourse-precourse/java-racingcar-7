package racingcar;

import camp.nextstep.edu.missionutils.Console;
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

        return result.toString();
    }

    private StringBuilder startRound() {
        StringBuilder result = new StringBuilder();

        for (Car car: cars) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            if(randomNumber >= MIN_MOVE_CONDITION) {
                car.move();
                String distance = "-".repeat(car.getDistance());
                result.append(car.getName());
                result.append(" : ");
                result.append(distance);
                result.append('\n');
            }
        }

        return result;
    }
}
