package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RacingController {
    private ArrayList<Car> cars;

    public RacingController(List<String> carNames) {
        this.cars = createCars(carNames);
    }

    public void progressRace(int raceCount) {
        System.out.println("\n실행 결과");
        for (int i = 0; i < raceCount; i++) {
            startRace();
            printRaceResult();
            System.out.println();
        }
    }

    private ArrayList<Car> createCars(List<String> carNames) {
        ArrayList<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }

    private void startRace() {
        for (Car car : cars) {
            car.incrementFowardCount(Randoms.pickNumberInRange(0, 9));
        }
    }

    private void printRaceResult() {
        for (Car car : cars) {
            String raceResult = car.getName() + " : " + "-".repeat(car.getForwardCount());
            System.out.println(raceResult);
        }
    }

    public ArrayList<Car> getCars() {
        return cars;
    }
}
