package racingcar;

// 입력, 실행, 출력을 담당함

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class GameController {

    private InputView inputView;

    public void gameStart() {
        List<Car> cars = input();

        playGame(cars);
    }

    public List<Car> input() {
        List<String> carNames = inputView.inputCarName();
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            Car car = new Car(carName);
            cars.add(car);
        }

        return cars;
    }

    public void playGame(List<Car> cars) {
        int maxRound = InputView.inputTryCount();
        System.out.println("실행 결과");
        for (int round = 1; round <= maxRound; round++) {
            for (Car car : cars) {
                int num = Randoms.pickNumberInRange(0, 9);
                if (num >= 4) {
                    car.moveForward();
                }
                String dash = "-".repeat(car.getPosition());
                System.out.println(car.getName() + " : " + dash);
            }
        }

    }
}
