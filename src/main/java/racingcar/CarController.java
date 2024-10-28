package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class CarController {
    private List<Car> cars;

    public CarController(List<String> carNames) {
        this.cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name, 0));
        }
    }

    public void moveCar() {
        for (Car car : cars) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            if (randomNumber>=4) car.move();
        }
    }

    public void racingGame(int count) {
        System.out.println("\n실행 결과");
        for (int i = 0; i < count; i++) {
            moveCar();
            OutputView.displayResult(cars);
        }
    }
}
