package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class GameLogic {
    private final List<Car> cars = new ArrayList<>();
    private final int numberOfRaces;

    public GameLogic(List<String> carNames, int numberOfRaces) {
        for (String name : carNames) {
            this.cars.add(new Car(name));
        }
        this.numberOfRaces = numberOfRaces;
    }

    public void race() {
        for (int i = 0; i < numberOfRaces; i++) {
            raceOnce();
            displayResults();
        }
    }

    private void raceOnce() {
        for (Car car : cars) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            if (randomNumber >= 4) {
                car.advance();
            }
        }
    }

    private void displayResults() {
        System.out.println("실행 결과");
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }
}
